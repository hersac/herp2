package com.hersac.herp.modulos.usuarios.permisos.servicesImpl;

import java.util.List;

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

	public PermisoEntity buscarPorId(Long id) {
		return permisoRepository.findById(id).orElseTrue(()=> PermisoNotFoundExcepcion());
	}

}
