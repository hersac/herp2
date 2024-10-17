package com.hersac.herp.modulos.usuarios.permisos.servicesImpl;

import java.util.List;

import com.hersac.herp.config.exceptions.usuarios.PermisoNotFoundException;
import com.hersac.herp.modulos.usuarios.permisos.dto.ActualizarPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.dto.CrearPermisoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.herp.modulos.usuarios.permisos.PermisosServices;
import com.hersac.herp.modulos.usuarios.permisos.entities.PermisoEntity;
import com.hersac.herp.modulos.usuarios.permisos.entities.repositories.PermisoRepository;
import com.hersac.herp.modulos.usuarios.permisos.mappers.PermisoMapper;

@Service
public class PermisosServicesImpl implements PermisosServices {
	@Autowired
	private PermisoRepository permisoRepository;

	@Autowired
	private PermisoMapper permisoMapper;

	public List<PermisoEntity> buscarTodos() {
		return permisoRepository.findAll();
	}
	public PermisoEntity buscarPorId(Long permisoId) {
		return permisoRepository
				.findById(permisoId)
				.orElseThrow(()-> new PermisoNotFoundException("Permiso no encontrado"));
	}
	public PermisoEntity crear(CrearPermisoDTO dto) {
		return permisoRepository.save(permisoMapper.toEntity(dto));
	}

	public PermisoEntity actualizar(Long permisoId, ActualizarPermisoDTO datosNuevos) {
		PermisoEntity permiso = permisoRepository.findById(permisoId)
				.orElseThrow(()-> new PermisoNotFoundException("Permiso no encontrado"));
		return permisoRepository.save(permisoMapper.updateToEntity(datosNuevos, permiso));
	}

	public void eliminar(Long permisoId) {
		permisoRepository.findById(permisoId)
				.orElseThrow(()-> new PermisoNotFoundException("Permiso no encontrado"));
		permisoRepository.deleteById(permisoId);
	}

}
