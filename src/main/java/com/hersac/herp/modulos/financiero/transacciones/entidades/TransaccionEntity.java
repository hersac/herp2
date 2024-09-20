package com.hersac.herp.modulos.financiero.transacciones.entidades;

import com.hersac.herp.modulos.financiero.cuentas.entidades.CuentaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "transacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaccionId;

    private Date fecha;
    private String descripcion;
    private Double monto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_transaccion_id")
    private TipoTransaccionEntity tipoTransaccionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id")
    private CuentaEntity cuentaId;
}
