package fr.cls.atoll.motu.web.usl.request.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.Template;

import fr.cls.atoll.motu.api.message.MotuRequestParametersConstant;
import fr.cls.atoll.motu.api.message.xml.ErrorType;
import fr.cls.atoll.motu.web.bll.BLLManager;
import fr.cls.atoll.motu.web.bll.exception.MotuException;
import fr.cls.atoll.motu.web.bll.request.model.RequestProduct;
import fr.cls.atoll.motu.web.dal.config.xml.model.ConfigService;
import fr.cls.atoll.motu.web.dal.config.xml.model.MotuConfig;
import fr.cls.atoll.motu.web.dal.request.netcdf.data.CatalogData;
import fr.cls.atoll.motu.web.dal.request.netcdf.data.Product;
import fr.cls.atoll.motu.web.usl.request.parameter.CommonHTTPParameters;
import fr.cls.atoll.motu.web.usl.request.parameter.exception.InvalidHTTPParameterException;
import fr.cls.atoll.motu.web.usl.request.parameter.validator.ProductHTTPParameterValidator;
import fr.cls.atoll.motu.web.usl.request.parameter.validator.ServiceHTTPParameterValidator;
import fr.cls.atoll.motu.web.usl.response.velocity.VelocityTemplateManager;
import fr.cls.atoll.motu.web.usl.response.velocity.model.converter.VelocityModelConverter;

/**
 * <br>
 * <br>
 * Copyright : Copyright (c) 2016 <br>
 * <br>
 * Société : CLS (Collecte Localisation Satellites) <br>
 * <br>
 * This interface is used to download data with subsetting.<br>
 * Operation invocation consists in performing an HTTP GET request.<br>
 * Input parameters are the following: [x,y] is the cardinality<br>
 * <ul>
 * <li><b>action</b>: [1]: {@link #ACTION_NAME}</li>
 * <li><b>service</b>: [1]: The selected service.</li>
 * <li><b>datasetID</b>: [1]: The dateset id. For Motu it represents a product ID.</li>
 * </ul>
 * 
 * @author Sylvain MARTY
 * @version $Revision: 1.1 $ - $Date: 2007-05-22 16:56:28 $
 */
public class DescribeCoverageAction extends AbstractAuthorizedAction {

    public static final String ACTION_NAME = "describecoverage";

    private ServiceHTTPParameterValidator serviceHTTPParameterValidator;
    private ProductHTTPParameterValidator productHTTPParameterValidator;

    /**
     * 
     * @param actionName_
     */
    public DescribeCoverageAction(String actionCode_, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        super(ACTION_NAME, actionCode_, request, response, session);

        serviceHTTPParameterValidator = new ServiceHTTPParameterValidator(
                MotuRequestParametersConstant.PARAM_SERVICE,
                CommonHTTPParameters.getServiceFromRequest(getRequest()));
        productHTTPParameterValidator = new ProductHTTPParameterValidator(
                MotuRequestParametersConstant.PARAM_DATASET_ID,
                CommonHTTPParameters.getDatasetIdFromRequest(getRequest()));

    }

    @Override
    public void process() throws MotuException {
        MotuConfig mc = BLLManager.getInstance().getConfigManager().getMotuConfig();
        ConfigService cs = BLLManager.getInstance().getConfigManager().getConfigService(serviceHTTPParameterValidator.getParameterValueValidated());
        if (checkConfigService(cs, serviceHTTPParameterValidator)) {
            CatalogData cd = BLLManager.getInstance().getCatalogManager().getCatalogAndProductCacheManager().getCatalogCache()
                    .getCatalog(cs.getName());
            if (cd != null) {
                String productId = productHTTPParameterValidator.getParameterValueValidated();
                Product p = BLLManager.getInstance().getCatalogManager().getProductManager().getProduct(cs.getName(), productId);
                if (checkProduct(p, productId)) {
                    RequestProduct rp = new RequestProduct(p);
                    writeResponseWithVelocity(mc, cs, cd, rp);
                }
            } else {
                throw new MotuException(ErrorType.SYSTEM, "Error while get catalog data for config service " + cs.getName());
            }
        }
    }

    private void writeResponseWithVelocity(MotuConfig mc_, ConfigService cs_, CatalogData cd, RequestProduct requestProduct) throws MotuException {
        Map<String, Object> velocityContext = new HashMap<String, Object>(2);
        velocityContext.put("service", VelocityModelConverter.convertToService(mc_, cs_, cd));
        velocityContext.put("product", VelocityModelConverter.convertToProduct(requestProduct));

        try {
            Template template = VelocityTemplateManager.getInstance().getVelocityEngine()
                    .getTemplate(VelocityTemplateManager.getTemplatePath(ACTION_NAME, VelocityTemplateManager.DEFAULT_LANG, true));
            String response = VelocityTemplateManager.getInstance().getResponseWithVelocity(velocityContext, template);
            writeResponse(response);
        } catch (Exception e) {
            throw new MotuException(ErrorType.SYSTEM, "Error while using velocity template", e);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void checkHTTPParameters() throws InvalidHTTPParameterException {
        serviceHTTPParameterValidator.validate();
        productHTTPParameterValidator.validate();
    }

}
