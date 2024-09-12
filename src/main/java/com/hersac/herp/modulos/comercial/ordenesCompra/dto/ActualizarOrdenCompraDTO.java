package com.hersac.herp.modulos.comercial.ordenesCompra.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Date;

public class ActualizarOrdenCompraDTO {

    @NotNull(message = "El id no puede ser nulo")
    @Positive(message = "El id debe ser positivo")
    private Long id;

    @NotBlank(message = "La fecha no puede ser nula o vacía")
    @Max(value = 10, message = "La fecha no puede tener más de 10 caracteres")
    private Date fecha;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estaActiva = true;

    @NotNull(message = "El total no puede ser nulo")
    private Integer total;

    @NotNull(message = "El proveedor no puede ser nulo")
    @Positive(message = "El proveedor debe ser positivo")
    private Long proveedor;
}
