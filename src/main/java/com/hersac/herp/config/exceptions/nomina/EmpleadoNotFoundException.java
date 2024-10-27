package com.hersac.herp.config.exceptions.nomina;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class EmpleadoNotFoundException extends GlobalException {
    public EmpleadoNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
