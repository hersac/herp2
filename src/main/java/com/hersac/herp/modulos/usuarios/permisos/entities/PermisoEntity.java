package com.hersac.herp.modulos.usuarios.permisos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity( name = "permisos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermisoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long permisoId;

	private String nombre;
	private String descripcion;
}
