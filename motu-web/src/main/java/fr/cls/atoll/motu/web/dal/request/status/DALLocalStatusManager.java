package fr.cls.atoll.motu.web.dal.request.status;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fr.cls.atoll.motu.web.bll.exception.MotuException;
import fr.cls.atoll.motu.web.bll.request.status.data.DownloadStatus;
import fr.cls.atoll.motu.web.bll.request.status.data.RequestStatus;
import fr.cls.atoll.motu.web.dal.config.xml.model.MotuConfig;

public class DALLocalStatusManager implements IDALRequestStatusManager {

    private Map<String, RequestStatus> requestStatusMap;

    public DALLocalStatusManager() {
        requestStatusMap = new HashMap<>();
    }

    @Override
    public void init() {
    }

    @Override
    public RequestStatus getRequestStatus(String requestId) {
        RequestStatus requestStatus = null;
        if (requestStatusMap.containsKey(requestId)) {
            requestStatus = requestStatusMap.get(requestId);
        }
        return requestStatus;
    }

    @Override
    public String addNewRequestStatus(RequestStatus request) throws MotuException {
        String requestId = computeRequestId();
        requestStatusMap.put(requestId, request);
        return requestId;
    }

    @Override
    public boolean updateRequestStatus(String requestId, RequestStatus request) {
        boolean result = true;
        if (requestStatusMap.containsKey(requestId)) {
            requestStatusMap.put(requestId, request);
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public Map<String, RequestStatus> getAllRequestStatus() {
        return Collections.unmodifiableMap(requestStatusMap);
    }

    @Override
    public boolean removeRequestStatus(String requestId) {
        requestStatusMap.remove(requestId);
        return true;
    }

    @Override
    public Set<String> getAllRequestId() {
        return requestStatusMap.keySet();
    }

    private String computeRequestId() {
        String requestId = null;
        do {
            requestId = Long.toString(System.currentTimeMillis());
        } while (requestStatusMap.containsKey(requestId));
        return requestId;
    }

    @Override
    public void setOutputFileName(String requestId, String fileName) {
        RequestStatus requestStatus = requestStatusMap.get(requestId);
        if (requestStatus != null) {
            if (requestStatus instanceof DownloadStatus) {
                ((DownloadStatus) requestStatus).setOutputFileName(fileName);
            }
        }
    }

    @Override
    public void onMotuConfigUpdate(MotuConfig newMotuConfig) {
        // nothing todo
    }
}
