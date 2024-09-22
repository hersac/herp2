package com.hersac.herp.modulos.financiero.transacciones.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tipos_transacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoTransaccionEntity {
    @Id
    @Column(unique = true)
    private Long tipoTransaccionId;

    private String nombre;
    private String descripcion;
}
