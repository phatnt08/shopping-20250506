package com.shopping.product_service.exception;

import java.nio.file.AccessDeniedException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shopping.product_service.dto.response.ApiResponse;

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
        return ResponseEntity.badRequest()
                .body(ApiResponse.<String>builder().code(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
                        .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage()).build());
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<String>> handleAppException(AppException e) {
        log.error("An error occurred", e);
        return ResponseEntity.status(e.getErrorCode().getHttpStatusCode())
                .body(ApiResponse.<String>builder().code(e.getErrorCode().getCode())
                        .message(e.getErrorCode().getMessage()).build());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ApiResponse<String>> handleAccessDeniedException(AccessDeniedException e) {
        ApiResponse<String> response = new ApiResponse<>();

        response.setCode(ErrorCode.FORBIDDEN.getCode());
        response.setMessage(ErrorCode.FORBIDDEN.getMessage());

        return ResponseEntity.status(ErrorCode.FORBIDDEN.getHttpStatusCode()).body(response);
    }

}
