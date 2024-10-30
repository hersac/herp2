package com.hersac.herp.modulos.pos.ventas.dto;

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
public class CrearVentaDTO {

    @NotBlank(message = "La fecha de ingreso es requerida")
    @Max(value = 10, message = "La fecha de ingreso no puede tener más de 10 caracteres y debe tener el formato [ AAAA-MM-DD ]")
    private String fechaVenta;

    @NotNull(message = "El total de la venta es requerido")
    @Positive(message = "El total de la venta debe ser mayor a 0")
    private Double totalVenta;

    @NotNull(message = "El usuario es requerido")
    @Positive(message = "El usuario es requerido")
    private Long usuarioId;

    @NotNull(message = "El cliente es requerido")
    @Positive(message = "El cliente es requerido")
    private Long clienteId;
}
