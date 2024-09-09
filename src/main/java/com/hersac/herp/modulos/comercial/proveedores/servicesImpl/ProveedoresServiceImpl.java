package com.hersac.herp.modulos.comercial.proveedores.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.herp.config.exceptions.ProveedorNotFoundException;
import com.hersac.herp.modulos.comercial.proveedores.ProveedoresService;
import com.hersac.herp.modulos.comercial.proveedores.dto.ActualizarProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.dto.CrearProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;
import com.hersac.herp.modulos.comercial.proveedores.entidades.repositorios.ProveedorRepository;
import com.hersac.herp.modulos.comercial.proveedores.mappers.ProveedorMapper;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
	@Autowired
	private ProveedorRepository proveedorRepository;
	@Autowired
	private ProveedorMapper map;

	@Override
	public List<ProveedorEntity> buscarTodos() {
		return proveedorRepository.findAll();
	}

	@Override
	public ProveedorEntity buscarPorId(Long id) {
		return proveedorRepository.findById(id).orElseThrow(() -> new ProveedorNotFoundException("El proveedor no existe"));
	}

	@Override
	public ProveedorEntity crear(CrearProveedorDTO proveedor) {
		return proveedorRepository.save(map.toEntity(proveedor));
	}

	@Override
	public ProveedorEntity actualizar(Long proveedorId, ActualizarProveedorDTO datosNuevos) {
		ProveedorEntity proveedorExistente = proveedorRepository.findById(proveedorId)
				.orElseThrow(() -> new ProveedorNotFoundException("El proveedor no existe"));
		return proveedorRepository.save(map.updateToEntity(datosNuevos, proveedorExistente));
	}

	@Override
	public void eliminar(Long id) {
		proveedorRepository.deleteById(id);
	}
}
