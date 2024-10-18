package com.hersac.herp.modulos.usuarios.rolesPermisos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolPermisoId implements Serializable {
    private Long rolId;
    private Long permisoId;

    @Override
    public int hashCode() {
        return Objects.hash(rolId, permisoId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolPermisoId that = (RolPermisoId) o;
        return Objects.equals(rolId, that.rolId) && Objects.equals(permisoId, that.permisoId);
    }

}
