package com.hersac.herp.modulos.usuarios.usuarios.entities;

import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

@Entity(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    private String nombre;
    private String email;
    private String contrasena;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id")
    private RolEntity rolId;
}
