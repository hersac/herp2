package com.hersac.herp.modulos.usuarios.roles;

import com.hersac.herp.modulos.usuarios.roles.dto.ActualizarRolDTO;
import com.hersac.herp.modulos.usuarios.roles.dto.CrearRolDTO;
import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;

import java.util.List;

public interface RolesServices {
    public List<RolEntity> buscarTodos();
    public RolEntity buscarPorId(Long rolId);
    public RolEntity crear(CrearRolDTO dto);
    public RolEntity actualizar(Long rolId, ActualizarRolDTO datosNuevos);
    public void eliminar(Long rolId);
}
