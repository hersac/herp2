package com.hersac.herp.modulos.comercial.proveedores.dto;

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
public class ActualizarProveedorDTO {

	@NotNull(message = "El id es requerido")
	@Positive(message = "El id no puede ser negativo")
	private String id;

	@NotBlank
	(message = "El nombre es requerido")
	@Positive(message = "El nombre no puede ser negativo")
	private String nombre;

	@NotBlank(message = "El contacto es requerido")
	@Size(max = 50, message = "El contacto no puede tener más de 50 caracteres")
	private String contacto;

	@NotBlank(message = "La dirección es requerida")
	@Size(max = 100, message = "La dirección no puede tener más de 50 caracteres")
	private String direccion;

	@NotBlank(message = "El teléfono es requerido")
	@Size(max = 10, message = "El teléfono no puede tener más de 10 caracteres")
	private String telefono;

	@NotBlank(message = "El email es requerido")
	@Size(max = 50, message = "El email no puede tener más de 50 caracteres")
	private String email;
}
