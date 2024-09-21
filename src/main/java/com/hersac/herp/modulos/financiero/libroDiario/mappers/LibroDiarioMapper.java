package com.hersac.herp.modulos.financiero.libroDiario.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.hersac.herp.modulos.financiero.libroDiario.dto.ActualizarLibroDiarioDTO;
import com.hersac.herp.modulos.financiero.libroDiario.dto.CrearLibroDiarioDTO;
import com.hersac.herp.modulos.financiero.libroDiario.entities.LibroDiarioEntity;

@Mapper(componentModel = "spring")
public interface LibroDiarioMapper {

    @Mapping(target = "libroDiarioId", ignore = true)
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "detalles", source = "detalles")
    @Mapping(target = "montoDebe", source = "montoDebe")
    @Mapping(target = "montoHaber", source = "montoHaber")
    @Mapping(target = "cuentaId", ignore = true)
    public LibroDiarioEntity toEntity(CrearLibroDiarioDTO dto);

    @Mapping(target = "libroDiarioId", source = "id")
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "detalles", source = "detalles")
    @Mapping(target = "montoDebe", source = "montoDebe")
    @Mapping(target = "montoHaber", source = "montoHaber")
    @Mapping(target = "cuentaId", ignore = true)
    public LibroDiarioEntity updateToEntity(ActualizarLibroDiarioDTO dto, @MappingTarget LibroDiarioEntity entity);
}
