package com.ays.exception;

public class ApiException extends RuntimeException {
    private String requestId;
    private String code;
    private String reason;
    private String errorMessage;
    private Throwable throwable;

    public ApiException(String requestId, String code, String reason, String errorMessage) {
        this.requestId = requestId;
        this.code = code;
        this.reason = reason;
        this.errorMessage = errorMessage;
    }

    public ApiException(String requestId, String code, String reason, String errorMessage, Throwable throwable) {
        this.requestId = requestId;
        this.code = code;
        this.reason = reason;
        this.errorMessage = errorMessage;
        this.throwable = throwable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}