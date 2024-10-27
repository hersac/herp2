package com.hersac.herp.modulos.nomina.nominas.entities;

import com.hersac.herp.modulos.nomina.empleados.entities.EmpleadoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "nominas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NominaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nominaId;

    private String fechaPago;
    private String salarioBruto;
    private String impuestos;
    private String salarioNeto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empleadoId")
    private EmpleadoEntity empleadoId;
}
