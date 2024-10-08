package com.hersac.herp.modulos.usuarios.permisos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarPermisoDTO {
	
	@NotNull(message = "El id del permiso es requerido")
	@Positive(message = "El id del permiso debe ser positivo")
	private Long permisoId;

	@NotBlank(message = "El nombre del permiso es requerido")
	@Size(min = 3, max = 50, message = "El nombre del permiso debe tener entre 3 y 50 caracteres")
	private String nombre;

	@NotBlank(message = "La descripción del permiso es requerida")
	@Size(min = 3, max = 255, message = "La descripción del permiso debe tener entre 3 y 255 caracteres")
	private String descripcion;
}
