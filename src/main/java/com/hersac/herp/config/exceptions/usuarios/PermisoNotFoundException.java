package com.hersac.herp.config.exceptions.usuarios;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class PermisoNotFoundException extends GlobalException {
    public PermisoNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}