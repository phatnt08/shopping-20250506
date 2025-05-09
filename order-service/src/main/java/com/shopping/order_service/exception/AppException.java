package com.shopping.order_service.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AppException extends RuntimeException {

    HttpStatus status;
    
    public AppException(HttpStatus status) {
        super(status.getReasonPhrase());
        this.status = status;
    }
}
