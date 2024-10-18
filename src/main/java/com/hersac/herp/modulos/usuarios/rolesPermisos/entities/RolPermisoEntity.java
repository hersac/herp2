package com.hersac.herp.modulos.usuarios.rolesPermisos.entities;

import com.hersac.herp.modulos.usuarios.permisos.entities.PermisoEntity;
import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "roles_permisos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RolPermisoId.class)
public class RolPermisoEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rolId;

    @Id
    @ManyToOne
    @JoinColumn(name = "permiso_id", nullable = false)
    private PermisoEntity permisoId;
}
