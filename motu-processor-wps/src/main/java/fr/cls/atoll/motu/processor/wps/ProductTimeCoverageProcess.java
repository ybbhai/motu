/* 
 * Motu, a high efficient, robust and Standard compliant Web Server for Geographic
 * Data Dissemination.
 *
 * http://cls-motu.sourceforge.net/
 *
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites) - 
 * http://www.cls.fr - and  Contributors
 *
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cls.atoll.motu.processor.wps;

import fr.cls.atoll.motu.api.message.xml.TimeCoverage;
import fr.cls.atoll.motu.library.misc.exception.MotuException;
import fr.cls.atoll.motu.library.misc.exception.MotuExceptionBase;
import fr.cls.atoll.motu.library.misc.intfce.Organizer;
import fr.cls.atoll.motu.processor.wps.framework.WPSUtils;

import org.apache.log4j.Logger;
import org.deegree.services.controller.OGCFrontController;
import org.deegree.services.wps.Processlet;
import org.deegree.services.wps.ProcessletException;
import org.deegree.services.wps.ProcessletExecutionInfo;
import org.deegree.services.wps.ProcessletInputs;
import org.deegree.services.wps.ProcessletOutputs;
import org.deegree.services.wps.output.LiteralOutput;

/**
 * The purpose of this {@link Processlet} is to provide the time coverage of a product
 * 
 * @author last edited by: $Author: dearith $
 * 
 * @version $Revision: 1.11 $, $Date: 2009-10-28 15:48:01 $
 */
public class ProductTimeCoverageProcess extends MotuWPSProcess {

    /**
     * Constructeur.
     */
    public ProductTimeCoverageProcess() {
    }

    private static final Logger LOG = Logger.getLogger(ProductTimeCoverageProcess.class);

    /** {@inheritDoc} */
    @Override
    public void process(ProcessletInputs in, ProcessletOutputs out, ProcessletExecutionInfo info) throws ProcessletException {

        super.process(in, out, info);

        if (LOG.isDebugEnabled()) {
            LOG.debug("BEGIN TimeCoverageProcess.process(), context: " + OGCFrontController.getContext());
        }

        try {
            MotuWPSProcessData motuWPSProcessData = getProductInfoParameters(in);

            // -------------------------------------------------
            // get Time coverage
            // -------------------------------------------------
            if (!WPSUtils.isNullOrEmpty(motuWPSProcessData.getLocationDataParamIn())) {
                productGetTimeCoverage(in, motuWPSProcessData.getLocationDataParamIn().getValue());
            } else if (!WPSUtils.isNullOrEmpty(motuWPSProcessData.getServiceNameParamIn())
                    && !WPSUtils.isNullOrEmpty(motuWPSProcessData.getProductIdParamIn())) {
                productGetTimeCoverage(in, motuWPSProcessData.getServiceNameParamIn().getValue(), motuWPSProcessData.getProductIdParamIn().getValue());
            }
        } catch (MotuExceptionBase e) {
            setReturnCode(out, e, true);
        } finally {
            super.afterProcess(in, out, info);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("END TimeCoverageProcess.process()");
        }

        return;
    }

    /**
     * Product get time coverage.
     * 
     * @param response the response
     * @param locationData the location data
     * @throws ProcessletException
     * 
     */
    private void productGetTimeCoverage(ProcessletInputs in, String locationData) throws ProcessletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("productGetTimeCoverage(String, ProcessletOutputs) - entering");
        }

        Organizer organizer = getOrganizer(in);
        if (organizer == null) {
            return;
        }

        TimeCoverage timeCoverage = null;
        try {
            timeCoverage = organizer.getTimeCoverage(locationData);
        } catch (MotuException e) {
            LOG.error("productGetTimeCoverage(String, ProcessletOutputs)", e);
            // Do nothing error is in response code
        }

        productGetTimeCoverage(in, timeCoverage);

        if (LOG.isDebugEnabled()) {
            LOG.debug("productGetTimeCoverage(String, ProcessletOutputs) - exiting");
        }
    }

    /**
     * Product get time coverage.
     * 
     * @param response the response
     * @param serviceName the service name
     * @param productId the product id
     * @throws MotuExceptionBase
     * @throws ProcessletException
     * 
     */
    private void productGetTimeCoverage(ProcessletInputs in, String serviceName, String productId) throws MotuExceptionBase, ProcessletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("productGetTimeCoverage(String, String, ProcessletOutputs) - entering");
        }

        Organizer organizer = getOrganizer(in);
        if (organizer == null) {
            return;
        }

        TimeCoverage timeCoverage = null;
        try {
            timeCoverage = organizer.getTimeCoverage(serviceName, productId);
        } catch (MotuExceptionBase e) {

            LOG.error("productGetTimeCoverage(String, String, ProcessletOutputs", e);
            timeCoverage = Organizer.createTimeCoverage(e);
            throw e;
        }

        productGetTimeCoverage(in, timeCoverage);

        if (LOG.isDebugEnabled()) {
            LOG.debug("productGetTimeCoverage(String, String, ProcessletOutputs) - exiting");
        }
    }

    /**
     * Product get time coverage.
     * 
     * @param timeCoverage the time coverage
     * @param out the out
     * @throws ProcessletException
     */
    private void productGetTimeCoverage(ProcessletInputs in, TimeCoverage timeCoverage) throws ProcessletException {

        if (timeCoverage == null) {
            return;
        }

        MotuWPSProcessData motuWPSProcessData = getMotuWPSProcessData(in);

        LiteralOutput startParam = motuWPSProcessData.getStartDateParamOut();
        LiteralOutput endParam = motuWPSProcessData.getEndDateParamOut();
        // LiteralOutput codeParam = (LiteralOutput)
        // processletOutputs.getParameter(MotuWPSProcess.PARAM_CODE);
        // LiteralOutput msgParam = (LiteralOutput)
        // processletOutputs.getParameter(MotuWPSProcess.PARAM_MESSAGE);

        if (startParam != null) {
            startParam.setValue(timeCoverage.getStart().normalize().toXMLFormat());
        }
        if (endParam != null) {
            endParam.setValue(timeCoverage.getEnd().normalize().toXMLFormat());
        }

        setReturnCode(motuWPSProcessData.getProcessletOutputs(), timeCoverage.getCode().toString(), timeCoverage.getMsg(), false);
        // if (codeParam != null) {
        // codeParam.setValue(timeCoverage.getCode().toString());
        // }
        // if (msgParam != null) {
        // msgParam.setValue(timeCoverage.getMsg());
        // }

    }

    /** {@inheritDoc} */
    @Override
    public void destroy() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("ProductTimeCoverageProcess#destroy() called");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void init() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("ProductTimeCoverageProcess#init() called");
        }
        super.init();
    }

}