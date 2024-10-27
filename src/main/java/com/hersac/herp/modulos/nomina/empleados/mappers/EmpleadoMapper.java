package com.hersac.herp.modulos.nomina.empleados.mappers;

import com.hersac.herp.modulos.nomina.empleados.dto.ActualizarEmpleadoDTO;
import com.hersac.herp.modulos.nomina.empleados.dto.CrearEmpleadoDTO;
import com.hersac.herp.modulos.nomina.empleados.entities.EmpleadoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    @Mapping(target = "empleadoId", ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "direccion", source = "direccion")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "cargoId", ignore = true)
    @Mapping(target = "salarioBase", source = "salarioBase")
    @Mapping(target = "fechaIngreso", source = "fechaIngreso")
    public EmpleadoEntity toEntity(CrearEmpleadoDTO dto);

    @Mapping(target = "empleadoId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "direccion", source = "direccion")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "cargoId", ignore = true)
    @Mapping(target = "salarioBase", source = "salarioBase")
    @Mapping(target = "fechaIngreso", source = "fechaIngreso")
    public EmpleadoEntity updateToEntity(ActualizarEmpleadoDTO dto, @MappingTarget EmpleadoEntity entity);
}
