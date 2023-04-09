package iti.jets.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
    private String errorMessage;
    private int errorCode;
    private String errorDescription;

    public ErrorMessage() {
    }

    public ErrorMessage(String eMessage, int code, String description) {
        errorMessage = eMessage;
        errorCode = code;
        errorDescription = description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "[Error Message : " + errorMessage + "| Code : " + errorCode + "| Error Message : " + errorDescription
                + "]";
    }
}
