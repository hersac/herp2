package com.hersac.herp.config.exceptions;

import org.springframework.http.HttpStatus;

public class OrdenCompraNotFound extends GlobalException {
    public OrdenCompraNotFound(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
