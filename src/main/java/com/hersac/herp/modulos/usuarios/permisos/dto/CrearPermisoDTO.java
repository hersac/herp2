package com.hersac.herp.modulos.usuarios.permisos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearPermisoDTO {

	@NotBlank(message = "El nombre del permiso es requerido")
	@Size(min = 3, max = 50, message = "El nombre del permiso debe tener entre 3 y 50 caracteres")
	private String nombre;

	@NotBlank(message = "La descripción del permiso es requerida")
	private String descripcion;
}
