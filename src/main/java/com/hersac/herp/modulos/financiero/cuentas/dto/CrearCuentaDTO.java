package com.hersac.herp.modulos.financiero.cuentas.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearCuentaDTO {
    @NotBlank(message = "El nombre de la cuenta no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre de la cuenta debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotNull(message = "El saldo de la cuenta no puede estar vacío")
    private Double saldo;

    @NotBlank(message = "El tipo de cuenta no puede estar vacío")
    @Positive(message = "El tipo de cuenta debe ser un número positivo")
    private Long tipoCuenta;
}
