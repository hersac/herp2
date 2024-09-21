package com.hersac.herp.modulos.financiero.libroDiario.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearLibroDiarioDTO {

    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha debe ser pasada o presente")
    private Date fecha;

    @NotBlank(message = "Los detalles no pueden estar en blanco")
    @Size(max = 255, message = "Los detalles no pueden exceder los 255 caracteres")
    private String detalles;

    @NotNull(message = "El monto debe no puede ser nulo")
    private Double montoDebe;

    @NotNull(message = "El monto debe no puede ser nulo")
    private Double montoHaber;

    @NotNull(message = "La cuenta no puede ser nula")
    @Positive(message = "La cuenta debe ser un número positivo")
    private Long cuenta;
}
