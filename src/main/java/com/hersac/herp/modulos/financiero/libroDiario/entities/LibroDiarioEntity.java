package com.hersac.herp.modulos.financiero.libroDiario.entities;

import com.hersac.herp.modulos.financiero.cuentas.entidades.CuentaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "libros_diarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroDiarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libroDiarioId;

    private Date fecha;
    private String detalles;
    private Double montoDebe;
    private Double montoHaber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id")
    private CuentaEntity cuentaId;
}

