package com.hersac.herp.config.seguridad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalEXception extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public GlobalEXception( final String message) {
        super(message);
    }

}
