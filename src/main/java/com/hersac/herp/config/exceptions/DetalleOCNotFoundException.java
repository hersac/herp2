package com.hersac.herp.config.exceptions;

import org.springframework.http.HttpStatus;

public class DetalleOCNotFoundException extends GlobalException {
    public DetalleOCNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
