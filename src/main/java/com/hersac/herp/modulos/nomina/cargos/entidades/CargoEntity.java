package com.hersac.herp.modulos.nomina.cargos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cargos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoId;

    private String nombre;
    private String descripcion;
    private Double salarioMinimo;
    private Double salarioMaximo;
}
