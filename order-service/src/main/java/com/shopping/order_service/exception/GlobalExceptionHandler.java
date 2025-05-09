package com.shopping.order_service.exception;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shopping.order_service.dto.response.ApiResponse;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneralException(Exception e) {
        log.error("An error occurred", e);
        return ResponseEntity.internalServerError()
                .body(ApiResponse.<String>builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build());
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<String>> handleAppException(AppException e) {
        log.error("An error occurred", e);
        return ResponseEntity.status(e.getStatus().value())
                .body(ApiResponse.<String>builder().code(e.getStatus().value())
                        .message(e.getStatus().getReasonPhrase()).build());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ApiResponse<String>> handleAccessDeniedException(AccessDeniedException e) {
        ApiResponse<String> response = new ApiResponse<>();

        response.setCode(HttpStatus.FORBIDDEN.value());
        response.setMessage(HttpStatus.FORBIDDEN.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(response);
    }

}
