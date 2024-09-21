package com.hersac.herp.config.exceptions.financiero;

import org.springframework.http.HttpStatus;

import com.hersac.herp.config.exceptions.GlobalException;

public class LibroDiarioNotFoundException extends GlobalException {
    public LibroDiarioNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
