package com.hersac.herp.config.exceptions.auth;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class CredencialesInvalidasException extends GlobalException {
    public CredencialesInvalidasException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
