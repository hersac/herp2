package com.hersac.herp.modulos.comercial.ordenesCompra.dto;

import com.hersac.herp.modulos.comercial.proveedores.dto.CrearProveedorDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearOrdenCompraDTO {

    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha debe ser pasada o presente")
    private Date fecha;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estaActiva = true;

    @NotNull(message = "El total no puede ser nulo")
    private Double total;

    @NotNull(message = "El proveedor no puede ser nulo")
    @Positive(message = "El proveedor debe ser positivo")
    private CrearProveedorDTO proveedor;
}
