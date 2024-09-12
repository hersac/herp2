package com.hersac.herp.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public GlobalException(final String message) {
        super(message);
    }

}
