package com.hersac.herp.modulos.usuarios.usuarios.mappers;

import com.hersac.herp.modulos.usuarios.usuarios.dto.ActualizarUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.dto.CrearUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "usuarioId", ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "contrasena", source = "contrasena")
    @Mapping(target = "rolId", ignore = true)
    public UsuarioEntity toEntity(CrearUsuarioDTO dto);

    @Mapping(target = "usuarioId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "contrasena", source = "contrasena")
    @Mapping(target = "rolId", ignore = true)
    public UsuarioEntity updateToEntity(ActualizarUsuarioDTO datosNuevos, @MappingTarget UsuarioEntity entity);
}
