package com.hersac.herp.config.exceptions.financiero;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class TransaccionNotFoundException extends GlobalException {
    public TransaccionNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
