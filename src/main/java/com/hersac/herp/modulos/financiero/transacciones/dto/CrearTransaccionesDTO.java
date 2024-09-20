package com.hersac.herp.modulos.financiero.transacciones.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearTransaccionesDTO {

    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "La fecha debe ser pasada o presente")
    private Date fecha;

    @NotBlank(message = "La descripción no puede ser nula o vacía")
    @Size(min = 5, max = 100, message = "La descripción debe tener entre 5 y 100 caracteres")
    private String descripcion;

    @NotNull(message = "El monto no puede ser nulo")
    private Double monto;

    @NotNull(message = "El tipo de transacción no puede ser nulo")
    @Positive(message = "El tipo de transacción debe ser positivo")
    private Long tipoTransaccion;

    @NotNull(message = "La cuenta no puede ser nula")
    @Positive(message = "La cuenta debe ser positiva")
    private Long cuenta;
}
