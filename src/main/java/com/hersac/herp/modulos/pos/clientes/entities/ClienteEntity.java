package com.hersac.herp.modulos.pos.clientes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
}
