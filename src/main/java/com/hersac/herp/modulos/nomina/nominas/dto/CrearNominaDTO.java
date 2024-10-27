package com.hersac.herp.modulos.nomina.nominas.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearNominaDTO {

    @NotBlank(message = "La fecha de pago no puede estar vacía")
    @Max(value = 10, message = "La fecha de pago no puede tener más de 10 caracteres")
    private String fechaPago;

    @NotNull(message = "El salario bruto no puede estar vacío")
    @Positive(message = "El salario bruto debe ser mayor a 0")
    private Double salarioBruto;

    @NotNull(message = "Los impuestos no pueden estar vacíos")
    @Positive(message = "Los impuestos deben ser mayores a 0")
    private Double impuestos;

    @NotNull(message = "El salario neto no puede estar vacío")
    @Positive(message = "El salario neto debe ser mayor a 0")
    private Double salarioNeto;

    @NotNull(message = "El empleadoId no puede estar vacío")
    @Positive(message = "El empleadoId debe ser mayor a 0")
    private Long empleadoId;
}
