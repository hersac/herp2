package com.hersac.herp.config.exceptions;

import org.springframework.http.HttpStatus;

public class CategoriaNotFoundException extends GlobalException {
    public CategoriaNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
