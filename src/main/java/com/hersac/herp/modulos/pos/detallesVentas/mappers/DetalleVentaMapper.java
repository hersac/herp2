package com.hersac.herp.modulos.pos.detallesVentas.mappers;

import com.hersac.herp.modulos.pos.detallesVentas.dto.ActualizarDetalleVentaDTO;
import com.hersac.herp.modulos.pos.detallesVentas.dto.CrearDetalleVentaDTO;
import com.hersac.herp.modulos.pos.detallesVentas.entities.DetalleVentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DetalleVentaMapper {

    @Mapping(target = "detalleVentaId", ignore = true)
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "precioUnitario", source = "precioUnitario")
    @Mapping(target = "ventaId", ignore = true)
    @Mapping(target = "productoId", ignore = true)
    public DetalleVentaEntity toEntity(CrearDetalleVentaDTO dto);

    @Mapping(target = "detalleVentaId", source = "id")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "precioUnitario", source = "precioUnitario")
    @Mapping(target = "ventaId", ignore = true)
    @Mapping(target = "productoId", ignore = true)
    public DetalleVentaEntity updateToEntity(ActualizarDetalleVentaDTO datosNuevos, @MappingTarget DetalleVentaEntity entity);
}
