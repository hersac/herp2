package com.hersac.herp.modulos.financiero.transacciones.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tipos_transacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoTransaccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoTransaccionId;

    private String nombre;
    private String descripcion;
}
