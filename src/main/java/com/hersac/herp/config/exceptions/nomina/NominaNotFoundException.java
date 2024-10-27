package com.hersac.herp.config.exceptions.nomina;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class NominaNotFoundException extends GlobalException {
    public NominaNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
