package com.hersac.herp.modulos.usuarios.rolesPermisos.servicesImpl;

import com.hersac.herp.config.exceptions.usuarios.PermisoNotFoundException;
import com.hersac.herp.config.exceptions.usuarios.RolNotFoundException;
import com.hersac.herp.modulos.usuarios.permisos.entities.PermisoEntity;
import com.hersac.herp.modulos.usuarios.permisos.entities.repositories.PermisoRepository;
import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import com.hersac.herp.modulos.usuarios.roles.entities.repositories.RolRepository;
import com.hersac.herp.modulos.usuarios.rolesPermisos.RolesPermisosServices;
import com.hersac.herp.modulos.usuarios.rolesPermisos.entities.RolPermisoEntity;
import com.hersac.herp.modulos.usuarios.rolesPermisos.entities.RolPermisoId;
import com.hersac.herp.modulos.usuarios.rolesPermisos.entities.respositories.RolPermisoRepository;
import com.hersac.herp.modulos.usuarios.rolesPermisos.mappers.RolPermisoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesPermisosServicesImpl implements RolesPermisosServices {

    @Autowired
    private RolPermisoRepository rolPermisoRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private RolPermisoMapper rolPermisoMapper;

    @Override
    public void asignarPermiso(Long rolId, Long permisoId) {
        RolEntity rol = rolRepository
                .findById(rolId)
                .orElseThrow(()-> new RolNotFoundException("El rol con id "+rolId+" no existe"));

        PermisoEntity permiso = permisoRepository
                .findById(permisoId)
                .orElseThrow(()-> new PermisoNotFoundException("El permiso con id "+permisoId+" no existe"));

        RolPermisoEntity rolPermiso = new RolPermisoEntity(rol, permiso);

        rolPermisoRepository.save(rolPermiso);
    }

    @Override
    public void quitarPermiso(Long rolId, Long permisoId) {
        rolRepository
                .findById(rolId)
                .orElseThrow(()-> new RolNotFoundException("El rol con id "+rolId+" no existe"));

        permisoRepository
                .findById(permisoId)
                .orElseThrow(()-> new PermisoNotFoundException("El permiso con id "+permisoId+" no existe"));

        rolRepository.deleteById(rolId);
        permisoRepository.deleteById(permisoId);
    }
}
