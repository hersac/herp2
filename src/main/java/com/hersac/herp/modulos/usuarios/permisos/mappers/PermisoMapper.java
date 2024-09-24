package com.hersac.herp.modulos.usuarios.permisos.mappers;

import com.hersac.herp.modulos.usuarios.permisos.dto.ActualizarPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.dto.CrearPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.entities.PermisoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermisoMapper {
    public PermisoEntity toEntity(CrearPermisoDTO  dto);

    public PermisoEntity updateToEntity(ActualizarPermisoDTO nuevosDatos, @MappingTarget PermisoEntity entity);
}
