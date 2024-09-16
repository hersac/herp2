package com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto;

import com.hersac.herp.modulos.comercial.ordenesCompra.dto.ActualizarOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarDetalleOCDTO {

    @NotNull(message = "El id no puede ser nulo")
    @Positive(message = "El id debe ser positivo")
    private Long id;

    @NotNull(message = "La orden de compra no puede ser nula")
    @Positive(message = "La orden de compra debe ser positiva")
    private ActualizarOrdenCompraDTO ordenCompra;

    @NotNull(message = "El producto no puede ser nulo")
    @Positive(message = "El producto debe ser positivo")
    private ActualizarProductoDTO producto;

    @NotNull(message = "La cantidad no puede ser nula")
    @Positive(message = "La cantidad debe ser positiva")
    private Integer cantidad;

    @NotNull(message = "El precio no puede ser nulo")
    private Double precio;
}
