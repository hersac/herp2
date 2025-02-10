package com.hersac.herp.modulos.parametros.terceros.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "terceros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerceroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long terceroId;

    private String razonSocial;
    private String nit;
    private String direccion;
    private String telefono;
    private String email;
    private String contacto;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean esNatural;
}
