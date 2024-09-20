package com.hersac.herp.config.exceptions.comercial;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class CategoriaNotFoundException extends GlobalException {
    public CategoriaNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
