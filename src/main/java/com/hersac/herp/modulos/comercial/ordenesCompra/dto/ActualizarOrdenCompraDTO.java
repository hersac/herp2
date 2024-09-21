package com.hersac.herp.modulos.comercial.ordenesCompra.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarOrdenCompraDTO {

    @NotNull(message = "El id no puede ser nulo")
    @Positive(message = "El id debe ser positivo")
    private Long id;

    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha debe ser pasada o presente")
    private Date fecha;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estaActiva = true;

    @NotNull(message = "El total no puede ser nulo")
    private Double total;

    @NotNull(message = "El proveedor no puede ser nulo")
    @Positive(message = "El proveedor debe ser positivo")
    private Long proveedor;
}
