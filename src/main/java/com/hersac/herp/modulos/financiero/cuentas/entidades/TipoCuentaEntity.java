package com.hersac.herp.modulos.financiero.cuentas.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(unique = true)
    private Long tipoCuentaId;

    private String nombre;
}
