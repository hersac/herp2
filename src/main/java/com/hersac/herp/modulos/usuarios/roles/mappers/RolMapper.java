package com.hersac.herp.modulos.usuarios.roles.mappers;

import com.hersac.herp.modulos.usuarios.roles.dto.ActualizarRolDTO;
import com.hersac.herp.modulos.usuarios.roles.dto.CrearRolDTO;
import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RolMapper {
    @Mapping(target = "rolId", ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    public RolEntity toEntity(CrearRolDTO dto);

    @Mapping(target = "rolId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    public RolEntity updateToEntity(ActualizarRolDTO datosNuevos, @MappingTarget RolEntity entity);
}
