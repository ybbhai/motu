package fr.cls.atoll.motu.web.usl.wcs.data;

import java.util.ArrayList;
import java.util.List;

public class ExceptionData {

    private String errorCode;
    private List<String> errorMessage;
    private String locator;

    public ExceptionData() {
        errorCode = "";
        errorMessage = new ArrayList<>();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }
}
