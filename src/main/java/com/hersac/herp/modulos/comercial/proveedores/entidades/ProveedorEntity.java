package com.hersac.herp.modulos.comercial.proveedores.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "proveedores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proveedorId;

    private String nombre;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;
}
