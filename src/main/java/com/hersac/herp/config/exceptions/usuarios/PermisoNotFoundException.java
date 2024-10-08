package com.hersac.herp.config.exceptions.usuarios;

public class PermisoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PermisoNotFoundException() {
		super("Permiso no encontrado");
	}
}
