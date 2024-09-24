package com.hersac.herp.modulos.usuarios.usuarios.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearUsuarioDTO {

    @NotBlank(message = "El nombre no puede ser nulo o vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El email no puede ser nulo o vacío")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotBlank(message = "La contraseña no puede ser nula o vacía")
    @Size(min = 8, max = 50, message = "La contraseña debe tener entre 8 y 50 caracteres")
    private String contrasena;

    @NotNull(message = "El rol no puede ser nulo")
    @Positive(message = "El rol debe ser positivo")
    private Long rol;
}
