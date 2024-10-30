package com.hersac.herp.modulos.pos.ventas.mappers;

import com.hersac.herp.modulos.pos.ventas.dto.ActualizarVentaDTO;
import com.hersac.herp.modulos.pos.ventas.dto.CrearVentaDTO;
import com.hersac.herp.modulos.pos.ventas.entities.VentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    @Mapping(target = "ventaId", ignore = true)
    @Mapping(target = "fechaVenta", source = "fechaVenta")
    @Mapping(target = "totalVenta", source = "totalVenta")
    @Mapping(target = "usuarioId", ignore = true)
    @Mapping(target = "clienteId", ignore = true)
    public VentaEntity toEntity(CrearVentaDTO dto);

    @Mapping(target = "ventaId", source = "id")
    @Mapping(target = "fechaVenta", source = "fechaVenta")
    @Mapping(target = "totalVenta", source = "totalVenta")
    @Mapping(target = "usuarioId", ignore = true)
    @Mapping(target = "clienteId", ignore = true)
    public VentaEntity updateToEntity(ActualizarVentaDTO datosNuevos, @MappingTarget VentaEntity venta);
}
