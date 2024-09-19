package com.hersac.herp.modulos.comercial.detallesOrdenesCompra.mappers;

import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.ActualizarDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.CrearDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DetalleOCMappers {

    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "ordenCompraId", ignore = true)
    @Mapping(target = "productoId", ignore = true)
    public DetalleOCEntity toEntity(CrearDetalleOCDTO dto);

    @Mapping(target = "detalleOCId", source = "id")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "ordenCompraId", ignore = true)
    @Mapping(target = "productoId", ignore = true)
    public DetalleOCEntity updateToEntity(ActualizarDetalleOCDTO dto, @MappingTarget DetalleOCEntity entity);

}
