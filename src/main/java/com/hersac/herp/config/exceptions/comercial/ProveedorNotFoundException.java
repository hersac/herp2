package com.hersac.herp.config.exceptions.comercial;

import com.hersac.herp.config.exceptions.GlobalException;
import org.springframework.http.HttpStatus;

public class ProveedorNotFoundException extends GlobalException {
	public ProveedorNotFoundException(final String message) {
		super(HttpStatus.BAD_REQUEST, message);
	}
}
