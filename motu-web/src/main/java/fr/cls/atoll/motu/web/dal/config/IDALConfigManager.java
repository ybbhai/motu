package fr.cls.atoll.motu.web.dal.config;

import java.util.List;
import java.util.Map;

import fr.cls.atoll.motu.web.bll.exception.MotuException;
import fr.cls.atoll.motu.web.dal.config.stdname.xml.model.StandardName;
import fr.cls.atoll.motu.web.dal.config.version.IDALVersionManager;
import fr.cls.atoll.motu.web.dal.config.xml.model.ConfigService;
import fr.cls.atoll.motu.web.dal.config.xml.model.MotuConfig;

/**
 * <br>
 * <br>
 * Copyright : Copyright (c) 2016 <br>
 * <br>
 * Société : CLS (Collecte Localisation Satellites)
 * 
 * @author Sylvain MARTY
 * @version $Revision: 1.1 $ - $Date: 2007-05-22 16:56:28 $
 */
public interface IDALConfigManager {

    /**
     * .
     * 
     * @return
     */
    String getCasServerUrl();

    /**
     * .
     * 
     * @return
     */
    boolean isCasActivated();

    /**
     * .
     * 
     * @throws MotuException
     */
    void init() throws MotuException;

    /**
     * .
     * 
     * @return
     */
    MotuConfig getMotuConfig();

    /**
     * .
     * 
     * @return
     */
    List<StandardName> getStandardNameList();

    /**
     * .
     * 
     * @return
     */
    String getMotuConfigurationFolderPath();

    /**
     * .
     * 
     * @return
     */
    IDALVersionManager getVersionManager();

    /**
     * Return the map of the available ConfigService. The keys are the name of the ConfigService. The values
     * are the ConfigService himself. .
     * 
     * @return the ConfigService map
     */
    Map<String, ConfigService> getConfigServiceMap();
}
