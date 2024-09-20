package com.hersac.herp.modulos.financiero.cuentas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tipos_cuentas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoCuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoCuentaId;

    private String nombre;
    private String descripcion;
}
