package com.hersac.herp.config.exceptions.financiero;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class CuentaNotFoundException extends GlobalException {
    public CuentaNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
