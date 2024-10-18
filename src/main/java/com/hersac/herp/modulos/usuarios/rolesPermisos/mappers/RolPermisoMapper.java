package com.hersac.herp.modulos.usuarios.rolesPermisos.mappers;

import com.hersac.herp.modulos.usuarios.rolesPermisos.dto.ActualizarRolPermisoDTO;
import com.hersac.herp.modulos.usuarios.rolesPermisos.dto.CrearRolPermisoDTO;
import com.hersac.herp.modulos.usuarios.rolesPermisos.entities.RolPermisoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolPermisoMapper {
    public RolPermisoEntity toEntity(CrearRolPermisoDTO dto);

    public RolPermisoEntity updateToEntity(ActualizarRolPermisoDTO datosNuevos, RolPermisoEntity entity);
}
