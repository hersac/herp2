package com.hersac.herp.modulos.comercial.proveedores.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.hersac.herp.modulos.comercial.proveedores.dto.ActualizarProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.dto.CrearProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {

	@Mapping(target = "nombre", source = "nombre")
	@Mapping(target = "contacto", source = "contacto")
	@Mapping(target = "direccion", source = "direccion")
	@Mapping(target = "telefono", source = "telefono")
	@Mapping(target = "email", source = "email")
	public ProveedorEntity toEntity(CrearProveedorDTO dto);

	@Mapping(target = "proveedorId", source = "id")
	@Mapping(target = "nombre", source = "nombre")
	@Mapping(target = "contacto", source = "contacto")
	@Mapping(target = "direccion", source = "direccion")
	@Mapping(target = "telefono", source = "telefono")
	@Mapping(target = "email", source = "email")
	public ProveedorEntity updateToEntity(ProveedorEntity proveedor, @MappingTarget ActualizarProveedorDTO dto);
}
