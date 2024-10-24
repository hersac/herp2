package com.hersac.herp.modulos.usuarios.rolesPermisos;

public interface RolesPermisosServices {
    public void asignarPermiso(Long rolId, Long permisoId);
    public void quitarPermiso(Long rolId, Long permisoId);
}
