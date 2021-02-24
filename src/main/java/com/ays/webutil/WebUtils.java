package com.ays.webutil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Ayush Agrahari created on 10/02/2021
 */
public final class WebUtils {

    private WebUtils() {
    }

    public static <D> ResponseEntity<ApiResponse<D>> toResponseEntity(ApiResponse<D> apiResponse) {
        HttpStatus httpStatus = apiResponse.getHttpStatusCode();
        apiResponse.setHttpStatusCode(null);
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
