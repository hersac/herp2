package com.hersac.herp.modulos.pos.clientes.mappers;

import com.hersac.herp.modulos.pos.clientes.dto.ActualizarClienteDTO;
import com.hersac.herp.modulos.pos.clientes.dto.CrearClienteDTO;
import com.hersac.herp.modulos.pos.clientes.entities.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "clienteId", ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "direccion", source = "direccion")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    public ClienteEntity toEntity(CrearClienteDTO dto);

    @Mapping(target = "clienteId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "direccion", source = "direccion")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    public ClienteEntity updateToEntity(ActualizarClienteDTO datosNuevos, @MappingTarget ClienteEntity entity);
}
