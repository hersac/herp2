package com.hersac.herp.modulos.nomina.empleados.dto;

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
public class CrearEmpleadoDTO {

    @NotBlank(message = "El nombre es requerido")
    @Max(value = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    @Max(value = 50, message = "El apellido no puede tener más de 50 caracteres")
    private String apellido;

    @NotBlank(message = "La dirección es requerida")
    @Max(value = 100, message = "La dirección no puede tener más de 100 caracteres")
    private String direccion;

    @NotBlank(message = "El teléfono es requerido")
    @Max(value = 10, message = "El teléfono no puede tener más de 10 digitos")
    private String telefono;

    @NotBlank(message = "El email es requerido")
    @Max(value = 50, message = "El email no puede tener más de 50 caracteres")
    private String email;

    @NotNull(message = "El cargo es requerido")
    @Positive(message = "El cargo es requerido")
    private Long cargoId;

    @NotNull(message = "El salario base es requerido")
    @Positive(message = "El salario base es requerido")
    private double salarioBase;

    @NotBlank(message = "La fecha de ingreso es requerida")
    @Max(value = 10, message = "La fecha de ingreso no puede tener más de 10 caracteres y debe tener el formato [ AAAA-MM-DD ]")
    private String fechaIngreso;
}
