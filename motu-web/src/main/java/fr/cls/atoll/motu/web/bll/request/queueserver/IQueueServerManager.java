package fr.cls.atoll.motu.web.bll.request.queueserver;

import java.util.Map;

import fr.cls.atoll.motu.web.bll.exception.MotuException;
import fr.cls.atoll.motu.web.bll.request.model.RequestDownloadStatus;
import fr.cls.atoll.motu.web.bll.request.queueserver.queue.QueueManagement;
import fr.cls.atoll.motu.web.dal.config.xml.model.ConfigService;
import fr.cls.atoll.motu.web.dal.config.xml.model.QueueServerType;
import fr.cls.atoll.motu.web.dal.config.xml.model.QueueType;

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
public interface IQueueServerManager {

    /**
     * .
     */
    void init();

    /**
     * .
     * 
     * @throws MotuException
     */
    void shutdown() throws MotuException;

    /**
     * .
     * 
     * @param userId
     * @return
     */
    boolean isNumberOfRequestTooHighForUser(String userId);

    /**
     * .
     * 
     * @param requestDownloadStatus
     * @param cs_
     * @param product_
     * @param extractionParameters
     * @throws MotuException
     */
    void execute(RequestDownloadStatus requestDownloadStatus, ConfigService cs_, double requestSizeInMB) throws MotuException;

    /**
     * .
     * 
     * @return
     */
    double getMaxDataThresholdInMegabyte();

    /**
     * .
     * 
     * @return
     */
    Map<QueueType, QueueManagement> getQueueManagementMap();

    /**
     * .
     */
    void stop();

    void onConfigUpdated(QueueServerType newQueueServerType);

}
