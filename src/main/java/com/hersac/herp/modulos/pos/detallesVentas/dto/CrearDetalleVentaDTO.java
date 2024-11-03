package com.hersac.herp.modulos.pos.detallesVentas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearDetalleVentaDTO {

    @NotNull(message = "La cantidad no puede ser nula")
    @Positive(message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @NotNull(message = "El precio unitario no puede ser nulo")
    private Double precioUnitario;

    @NotNull(message = "El id de la venta no puede ser nulo")
    @Positive(message = "El id de la venta debe ser mayor a 0")
    private Long venta;

    @NotNull(message = "El id del producto no puede ser nulo")
    @Positive(message = "El id del producto debe ser mayor a 0")
    private Long producto;
}
