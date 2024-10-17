package com.hersac.herp.modulos.usuarios.roles.servicesImpl;

import com.hersac.herp.config.exceptions.usuarios.RolNotFoundException;
import com.hersac.herp.modulos.usuarios.roles.RolesServices;
import com.hersac.herp.modulos.usuarios.roles.dto.ActualizarRolDTO;
import com.hersac.herp.modulos.usuarios.roles.dto.CrearRolDTO;
import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import com.hersac.herp.modulos.usuarios.roles.entities.repositories.RolRepository;
import com.hersac.herp.modulos.usuarios.roles.mappers.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServicesImpl implements RolesServices {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private RolMapper rolMapper;

    public List<RolEntity> buscarTodos(){
        return rolRepository.findAll();
    }

    public RolEntity buscarPorId(Long rolId) {
        return rolRepository
                .findById(rolId)
                .orElseThrow(() -> new RolNotFoundException("Rol no encontrado"));
    }

    public RolEntity crear(CrearRolDTO dto) {
        return rolRepository.save(rolMapper.toEntity(dto));
    }

    public RolEntity actualizar(Long rolId, ActualizarRolDTO datosNuevos) {
        RolEntity rol = rolRepository
                .findById(rolId)
                .orElseThrow(() -> new RolNotFoundException("Rol no encontrado"));
        return rolRepository.save(rolMapper.updateToEntity(datosNuevos, rol));
    }

    public void eliminar(Long rolId) {
        rolRepository
                .findById(rolId)
                .orElseThrow(() -> new RolNotFoundException("Rol no encontrado"));
        rolRepository.deleteById(rolId);
    }
}
