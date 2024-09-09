package com.hersac.herp.modulos.comercial.proveedores;

import java.util.List;

import com.hersac.herp.modulos.comercial.proveedores.dto.ActualizarProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.dto.CrearProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;

public interface ProveedoresService {
	public List<ProveedorEntity> buscarTodos();
	public ProveedorEntity buscarPorId(Long id);
	public ProveedorEntity crear(CrearProveedorDTO proveedor);
	public ProveedorEntity actualizar(Long proveedorId, ActualizarProveedorDTO datisNuevos);
	public void eliminar(Long id);
}
