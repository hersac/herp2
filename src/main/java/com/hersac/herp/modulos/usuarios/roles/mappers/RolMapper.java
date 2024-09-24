package com.hersac.herp.modulos.usuarios.roles.mappers;

import com.hersac.herp.modulos.usuarios.roles.dto.ActualizarRolDTO;
import com.hersac.herp.modulos.usuarios.roles.dto.CrearRolDTO;
import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RolMapper {
    public RolEntity toEntity(CrearRolDTO dto);

    public RolEntity updateToEntity(ActualizarRolDTO datosNuevos, @MappingTarget RolEntity entity);
}
