package com.ays.webutil;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class ApiResponse<D> {
    private HttpStatus httpStatusCode;
    private String requestId;
    private String code;
    private String reason;
    private String message;
    private Meta meta;
    private D data;
    private List<InterComponentError> errors;

    public ApiResponse(Builder<D> builder) {
        this.httpStatusCode = builder.httpStatusCode;
        this.requestId = builder.requestId;
        this.code = builder.code;
        this.reason = builder.reason;
        this.message = builder.message;
        this.meta = builder.meta;
        this.data = builder.data;
        this.errors = builder.errors;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(HttpStatus httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public List<InterComponentError> getErrors() {
        return errors;
    }

    public void setErrors(List<InterComponentError> errors) {
        this.errors = errors;
    }

    public static class Builder<D> {
        private final HttpStatus httpStatusCode;
        private final String requestId;
        private final String code;
        private final String reason;
        private final String message;
        private Meta meta;
        private D data;
        private List<InterComponentError> errors;

        public Builder(HttpStatus httpStatusCode, String requestId, String code, String reason, String message) {
            this.httpStatusCode = httpStatusCode;
            this.requestId = requestId;
            this.code = code;
            this.reason = reason;
            this.message = message;
        }

        public Builder<D> withMeta(Meta meta) {
            this.meta = meta;
            return this;
        }

        public Builder<D> withData(D data) {
            this.data = data;
            return this;
        }

        public Builder<D> withError(List<InterComponentError> interComponentErrors) {
            this.errors = interComponentErrors;
            return this;
        }

        public ApiResponse<D> build() {
            return new ApiResponse<>(this);
        }
    }
}
