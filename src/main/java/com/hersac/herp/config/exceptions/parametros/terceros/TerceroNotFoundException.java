package com.hersac.herp.config.exceptions.parametros.terceros;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class TerceroNotFoundException extends GlobalException {
    public TerceroNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
