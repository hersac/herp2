package com.hersac.herp.modulos.comercial.ordenesCompra.mappers;

import com.hersac.herp.modulos.comercial.ordenesCompra.dto.ActualizarOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.dto.CrearOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrdenCompraMapper {

    @Mapping(target = "ordenCompraId", ignore = true)
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "estaActiva", source = "estaActiva")
    @Mapping(target = "total", source = "total")
    @Mapping(target = "proveedorId", ignore = true)
    @Mapping(target = "detalles", ignore = true)
    public OrdenCompraEntity toEntity(CrearOrdenCompraDTO dto);

    @Mapping(target = "ordenCompraId", source = "id")
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "estaActiva", source = "estaActiva")
    @Mapping(target = "total", source = "total")
    @Mapping(target = "proveedorId", ignore = true)
    @Mapping(target = "detalles", ignore = true)
    public OrdenCompraEntity updateToEntity(ActualizarOrdenCompraDTO dto, @MappingTarget OrdenCompraEntity entity);
}
