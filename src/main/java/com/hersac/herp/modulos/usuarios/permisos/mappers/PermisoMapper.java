package com.hersac.herp.modulos.usuarios.permisos.mappers;

import com.hersac.herp.modulos.usuarios.permisos.dto.ActualizarPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.dto.CrearPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.entities.PermisoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermisoMapper {

	@Mapping(target = "permisoId", ignore = true)
	@Mapping(target = "nombre", source = "nombre")
	@Mapping(target = "descripcion", source = "descripcion")
    public PermisoEntity toEntity(CrearPermisoDTO  dto);

	@Mapping(target = "permisoId", source = "id")
	@Mapping(target = "nombre", source = "nombre")
	@Mapping(target = "descripcion", source = "descripcion")
    public PermisoEntity updateToEntity(ActualizarPermisoDTO nuevosDatos, @MappingTarget PermisoEntity entity);
}
