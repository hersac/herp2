package com.hersac.herp.modulos.usuarios.permisos.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity( name = "permisos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermisoEntity {
	private Long permisoId;
	private String nombre;
	private String descripcion;
}
