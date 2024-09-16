package com.hersac.herp.modulos.comercial.productos.dto;

import com.hersac.herp.modulos.comercial.categorias.dto.CrearCategoriaDTO;
import com.hersac.herp.modulos.comercial.proveedores.dto.CrearProveedorDTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearProdutoDTO {
    @NotBlank(message = "El nombre es requerido")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción es requerida")
    @Size(max = 100, message = "La descripción no puede tener más de 100 caracteres")
    private String descripcion;

    @NotNull(message = "El precio unitario es requerido")
    @Min(value = 0, message = "El precio unitario no puede ser negativo")
    private Double precio;

    @NotNull(message = "La cantidad disponible es requerida")
    @Min(value = 0, message = "La cantidad disponible no puede ser negativa")
    private Integer cantidad;

    @NotNull(message = "La categoría es requerida")
    @Positive(message = "La categoría no puede ser negativa")
    private CrearCategoriaDTO categoria;

    @NotNull(message = "El proveedor es requerido")
    @Positive(message = "El proveedor no puede ser negativo")
    private CrearProveedorDTO proveedor;
}
