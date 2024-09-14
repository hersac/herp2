package com.hersac.herp.modulos.comercial.detallesOrdenesCompra.mappers;

import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.ActualizarDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.CrearDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DetalleOCMappers {

    @Mapping(target = "detalleOCId", ignore = true)
    @Mapping(target = "ordenCompraId", source = "ordenCompra")
    @Mapping(target = "productoId", source = "producto")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "precio", source = "precio")
    public DetalleOCEntity toEntity(CrearDetalleOCDTO dto);

    @Mapping(target = "detalleOCId", source = "id")
    @Mapping(target = "ordenCompraId", source = "ordenCompra")
    @Mapping(target = "productoId", source = "producto")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "precio", source = "precio")
    public DetalleOCEntity updateToEntity(ActualizarDetalleOCDTO dto, @MappingTarget DetalleOCEntity entity);

}
