package com.hersac.herp.config.exceptions.usuarios;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class RolNotFoundException extends GlobalException {
    public RolNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
