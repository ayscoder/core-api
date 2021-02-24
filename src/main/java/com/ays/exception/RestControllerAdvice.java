package com.ays.exception;

import com.ays.webutil.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

/**
 * Let’s intercept those exceptions to force our custom format.
 * We need to override the ResponseEntityExceptionHandler and return the correctly formatted ResponseEntity by
 * creating a custom GlobalExceptionHandler.
 *
 * @author Ayush Agrahari created on 10/02/2021
 */
@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestControllerAdvice.class);

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> badRequestExceptionHandler(BadRequestException e) {
        ApiResponse<Object> apiResponse = new ApiResponse.Builder<>(HttpStatus.BAD_REQUEST, e.getRequestId(), e.getCode(), e.getReason(),
                e.getErrorMessage()).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
        ApiResponse<Object> apiResponse = new ApiResponse.Builder<>(HttpStatus.NOT_FOUND, e.getRequestId(), e.getCode(), e.getReason(),
                e.getErrorMessage()).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> apiExceptionHandler(Exception e) {
        logger.error("## Internal error has occurred while performing api operation, ErrorMsg:{}, Error:",e.getMessage(), e);
        ApiResponse<Object> apiResponse = new ApiResponse.Builder<>(HttpStatus.INTERNAL_SERVER_ERROR, UUID.randomUUID().toString(),
                "API-000","Internal server error", "Error has occurred while performing operation for given request id").build();
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
