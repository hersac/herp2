package com.hersac.herp.config.exceptions.usuarios;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class UsuarioNotFoundException extends GlobalException {
    public UsuarioNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
