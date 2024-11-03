package com.hersac.herp.modulos.pos.clientes.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarClienteDTO {

    @NotNull(message = "El id es requerido")
    @Positive(message = "El id debe ser un número positivo")
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    @Max(value = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    @Max(value = 50, message = "El apellido no puede tener más de 50 caracteres")
    private String apellido;

    @NotBlank(message = "La dirección es requerida")
    @Max(value = 100, message = "La dirección no puede tener más de 100 caracteres")
    private String direccion;

    @NotBlank(message = "El teléfono es requerido")
    @Max(value = 10, message = "El teléfono no puede tener más de 10 digitos")
    @Min(value = 7, message = "El teléfono no puede tener menos de 7 digitos")
    private String telefono;

    @NotBlank(message = "El email es requerido")
    @Max(value = 50, message = "El email no puede tener más de 50 caracteres")
    private String email;
}
