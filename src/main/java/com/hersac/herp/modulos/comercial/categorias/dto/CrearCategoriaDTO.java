package com.hersac.herp.modulos.comercial.categorias.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearCategoriaDTO {

    @NotBlank(message = "El nombre es requerido")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción es requerida")
    @Size(max = 100, message = "La descripción no puede tener más de 100 caracteres")
    private String descripcion;
}
