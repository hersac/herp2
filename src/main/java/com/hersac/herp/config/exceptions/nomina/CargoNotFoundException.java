package com.hersac.herp.config.exceptions.nomina;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class CargoNotFoundException extends GlobalException {
    public CargoNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
