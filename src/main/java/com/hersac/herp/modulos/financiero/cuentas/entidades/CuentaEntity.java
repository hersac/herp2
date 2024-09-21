package com.hersac.herp.modulos.financiero.cuentas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cuentas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;

    private String nombre;
    private Double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_cuenta_id")
    private TipoCuentaEntity tipoCuentaId;
}
