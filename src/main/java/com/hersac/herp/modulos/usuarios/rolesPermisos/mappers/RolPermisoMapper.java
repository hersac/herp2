package com.hersac.herp.modulos.usuarios.rolesPermisos.mappers;

import com.hersac.herp.modulos.usuarios.rolesPermisos.dto.ActualizarRolPermisoDTO;
import com.hersac.herp.modulos.usuarios.rolesPermisos.dto.CrearRolPermisoDTO;
import com.hersac.herp.modulos.usuarios.rolesPermisos.entities.RolPermisoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RolPermisoMapper {
/*
    @Mapping(target = "rolId", source = "rolId")
    @Mapping(target = "permisoId", source = "permisoId")
    public RolPermisoEntity toEntity(CrearRolPermisoDTO dto);

    @Mapping(target = "rolId", source = "rolId")
    @Mapping(target = "permisoId", source = "permisoId")
    public RolPermisoEntity updateToEntity(ActualizarRolPermisoDTO datosNuevos, RolPermisoEntity entity);
    */
}
