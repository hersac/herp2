package com.hersac.herp.modulos.nomina.cargos.mappers;

import com.hersac.herp.modulos.nomina.cargos.dto.ActualizarCargoDTO;
import com.hersac.herp.modulos.nomina.cargos.dto.CrearCargoDTO;
import com.hersac.herp.modulos.nomina.cargos.entidades.CargoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CargoMappper {

    @Mapping(target = "cargoId", ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "salarioMinimo", source = "salarioMinimo")
    @Mapping(target = "salarioMaximo", source = "salarioMaximo")
    public CargoEntity toEntity(CrearCargoDTO dto);

    @Mapping(target = "cargoId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "salarioMinimo", source = "salarioMinimo")
    @Mapping(target = "salarioMaximo", source = "salarioMaximo")
    public CargoEntity updateToEntity(ActualizarCargoDTO dto, @MappingTarget CargoEntity entity);
}
