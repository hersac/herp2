package com.hersac.herp.config.exceptions;

import org.springframework.http.HttpStatus;

public class ProductoNotFoundException extends GlobalEXception {
    public ProductoNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
