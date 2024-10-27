package com.hersac.herp.modulos.nomina.cargos.dto;

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
public class ActualizarCargoDTO {

    @NotNull(message = "El id del cargo es requerido")
    @Positive(message = "El id del cargo debe ser mayor a 0")
    private Long id;

    @NotBlank(message = "El nombre del cargo es requerido")
    @Max(value = 50, message = "El nombre del cargo no puede tener más de 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción del cargo es requerida")
    @Max(value = 255, message = "La descripción del cargo no puede tener más de 255 caracteres")
    private String descripcion;

    @NotNull(message = "El salario mínimo del cargo es requerido")
    @Positive(message = "El salario mínimo del cargo debe ser mayor a 0")
    private Double salarioMinimo;

    @NotNull(message = "El salario mínimo del cargo es requerido")
    @Positive(message = "El salario mínimo del cargo debe ser mayor a 0")
    private Double salarioMaximo;
}
