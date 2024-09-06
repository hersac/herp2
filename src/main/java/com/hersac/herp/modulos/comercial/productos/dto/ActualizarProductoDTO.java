package com.hersac.herp.modulos.comercial.productos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarProductoDTO {
    @NotBlank(message = "El nombre es requerido")
    @NotNull(message = "El nombre es requerido")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción es requerida")
    @NotNull(message = "La descripción es requerida")
    @Size(max = 100, message = "La descripción no puede tener más de 100 caracteres")
    private String descripcion;

    @NotNull(message = "El precio unitario es requerido")
    @Min(value = 0, message = "El precio unitario no puede ser negativo")
    private Double precioUnitario;

    @NotNull(message = "La cantidad disponible es requerida")
    @Min(value = 0, message = "La cantidad disponible no puede ser negativa")
    private Integer cantidadDisponible;

    @NotNull(message = "La categoría es requerida")
    private Long categoriaId;

    @NotNull(message = "El proveedor es requerido")
    private Long proveedorId;
}
