package com.hersac.herp.modulos.nomina.nominas.mappers;

import com.hersac.herp.modulos.nomina.nominas.dto.ActualizarNominaDTO;
import com.hersac.herp.modulos.nomina.nominas.dto.CrearNominaDTO;
import com.hersac.herp.modulos.nomina.nominas.entities.NominaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NominaMapper {

    @Mapping(target = "nominaId", ignore = true)
    @Mapping(target = "fechaPago", source = "fechaPago")
    @Mapping(target = "salarioBruto", source = "salarioBruto")
    @Mapping(target = "impuestos", source = "impuestos")
    @Mapping(target = "salarioNeto", source = "salarioNeto")
    @Mapping(target = "empleadoId", ignore = true)
    public NominaEntity toEntity(CrearNominaDTO dto);

    @Mapping(target = "nominaId", source = "id")
    @Mapping(target = "fechaPago", source = "fechaPago")
    @Mapping(target = "salarioBruto", source = "salarioBruto")
    @Mapping(target = "impuestos", source = "impuestos")
    @Mapping(target = "salarioNeto", source = "salarioNeto")
    @Mapping(target = "empleadoId", ignore = true)
    public NominaEntity updateToEntity(ActualizarNominaDTO dto, @MappingTarget NominaEntity entity);
}
