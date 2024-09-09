package com.hersac.herp.modulos.comercial.productos.mappers;

import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "precioUnitario", source = "precio")
    @Mapping(target = "cantidadDisponible", source = "cantidad")
    @Mapping(target = "categoriaId", source = "categoria")
    @Mapping(target = "proveedorId", source = "proveedor")
    public ProductoEntity toEntity(CrearProdutoDTO dto);

    @Mapping(target = "productoId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "precioUnitario", source = "precio")
    @Mapping(target = "cantidadDisponible", source = "cantidad")
    @Mapping(target = "categoriaId", source = "categoria")
    @Mapping(target = "proveedorId", source = "proveedor")
    public ProductoEntity updateToEntity(ActualizarProductoDTO dto, @MappingTarget ProductoEntity entity);
}
