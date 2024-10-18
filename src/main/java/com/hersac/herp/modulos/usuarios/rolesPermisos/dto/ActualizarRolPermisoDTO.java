package com.hersac.herp.modulos.usuarios.rolesPermisos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarRolPermisoDTO {
    @NotNull(message = "El rolId es requerido")
    @Positive(message = "El rolId debe ser un número positivo")
    private Long rolId;

    @NotNull(message = "El permisoId es requerido")
    @Positive(message = "El permisoId debe ser un número positivo")
    private Long permisoId;
}
