package com.hersac.herp.config.exceptions.pos;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class ClienteNotFoundException extends GlobalException {
    public ClienteNotFoundException(final String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
