package com.hersac.herp.modulos.nomina.empleados.entities;

import com.hersac.herp.modulos.nomina.cargos.entidades.CargoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleadoId;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private Double salarioBase;
    private String fechaIngreso;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id")
    private CargoEntity cargoId;
}
