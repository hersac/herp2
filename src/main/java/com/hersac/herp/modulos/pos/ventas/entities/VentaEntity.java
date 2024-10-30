package com.hersac.herp.modulos.pos.ventas.entities;

import com.hersac.herp.modulos.pos.clientes.entities.ClienteEntity;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ventaId;

    private String fechaVenta;
    private Double totalVenta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuarioId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clienteId")
    private ClienteEntity clienteId;
}
