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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.28 at 10:49:52 AM CEST 
//


package fr.cls.atoll.motu.processor.opengis.wps100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import fr.cls.atoll.motu.processor.opengis.ows110.ExceptionReport;


/**
 * Indicator that the process has failed to execute successfully. The reason for failure is given in the exception report. 
 * 
 * <p>Java class for ProcessFailedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessFailedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}ExceptionReport"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessFailedType", propOrder = {
    "exceptionReport"
})
public class ProcessFailedType {

    @XmlElement(name = "ExceptionReport", namespace = "http://www.opengis.net/ows/1.1", required = true)
    protected ExceptionReport exceptionReport;

    /**
     * Gets the value of the exceptionReport property.
     * 
     * @return
     *     possible object is
     *     {@link ExceptionReport }
     *     
     */
    public ExceptionReport getExceptionReport() {
        return exceptionReport;
    }

    /**
     * Sets the value of the exceptionReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExceptionReport }
     *     
     */
    public void setExceptionReport(ExceptionReport value) {
        this.exceptionReport = value;
    }

}
