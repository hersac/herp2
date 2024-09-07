package com.hersac.herp.modulos.comercial.productos.mappers;

import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public class ProductoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "precioUnitario", source = "precioUnitario")
    @Mapping(target = "cantidadDisponible", source = "cantidadDisponible")
    @Mapping(target = "categoria", source = "categoriaId")
    @Mapping(target = "proveedor", source = "proveedorId")
    public ProductoEntity toEntity(CrearProdutoDTO dto){
        return null;
    }

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "precioUnitario", source = "precioUnitario")
    @Mapping(target = "cantidadDisponible", source = "cantidadDisponible")
    @Mapping(target = "categoria", source = "categoriaId")
    @Mapping(target = "proveedor", source = "proveedorId")
    public ProductoEntity toEntity(ActualizarProductoDTO dto){
        return null;
    }
}
