package com.hersac.herp.modulos.usuarios.roles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearRolDTO {

    @NotBlank(message = "El nombre no puede ser nulo o vacío")
    @Size(min = 8, max = 20, message = "El nombre debe tener entre 8 y 20 caracteres")
    private String nombre;

    @NotBlank(message = "La descripcion no puede ser nula o vacía")
    @Size(min = 8, max = 50, message = "La descripcion debe tener entre 8 y 50 caracteres")
    private String descripcion;
}
