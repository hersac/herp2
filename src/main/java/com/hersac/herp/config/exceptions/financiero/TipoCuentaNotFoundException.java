package com.hersac.herp.config.exceptions.financiero;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class TipoCuentaNotFoundException extends GlobalException {
    public TipoCuentaNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
