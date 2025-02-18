package com.hersac.herp.modulos.parametros.terceros.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarTerceroDTO {

    @NotNull(message = "El id del cargo es requerido")
    @Positive(message = "El id del cargo debe ser mayor a 0")
    private Long id;

    @NotBlank(message = "La razón social es requerida")
    @Max(value = 50, message = "La razón social no puede tener más de 50 caracteres")
    @Min(value = 3, message = "El contacto no puede tener menos de 3 carácteres")
    private String razonSocial;

    @Max(value = 10, message = "El NIT no puede tener más de 10 carácteres")
    @Min(value = 9, message = "El NIT no puede tener menos de 9 carácteres")
    @NotBlank(message = "El NIT es requerido")
    private String nit;

    @NotBlank(message = "La dirección es requerida")
    @Max(value = 255, message = "La dirección no puede tener más de 255 carácteres")
    private String direccion;

    @NotBlank(message = "El teléfono es requerido")
    @Max(value = 10, message = "El teléfono no puede tener más de 10 carácteres")
    @Min(value = 7, message = "El teléfono no puede tener menos de 7 carácteres")
    private String telefono;

    @NotBlank(message = "El email es requerido")
    @Max(value = 50, message = "El email no puede tener más de 50 carácteres")
    @Email(message = "El email no es válido")
    private String email;

    @NotBlank(message = "El contacto es requerido")
    @Max(value = 50, message = "El contacto no puede tener más de 50 carácteres")
    @Min(value = 3, message = "El contacto no puede tener menos de 3 carácteres")
    private String contacto;

    private Boolean esNatural;
}
