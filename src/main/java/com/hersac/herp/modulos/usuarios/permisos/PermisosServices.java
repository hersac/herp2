package com.hersac.herp.modulos.usuarios.permisos;

import java.util.List;

import com.hersac.herp.modulos.usuarios.permisos.dto.ActualizarPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.dto.CrearPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.entities.PermisoEntity;

public interface PermisosServices {
	public List<PermisoEntity> buscarTodos();
	public PermisoEntity buscarPorId(Long permisoId);
	public PermisoEntity crear(CrearPermisoDTO permiso);
	public PermisoEntity actualizar(Long permisoId, ActualizarPermisoDTO datosNuevos);
	public void eliminar(Long permisoId);
}
