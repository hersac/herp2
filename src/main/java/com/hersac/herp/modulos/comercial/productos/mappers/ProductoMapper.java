package com.hersac.herp.modulos.comercial.productos.mappers;

import com.hersac.herp.modulos.comercial.categorias.mappers.CategoriaMapper;
import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import com.hersac.herp.modulos.comercial.proveedores.mappers.ProveedorMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class, ProveedorMapper.class})
public interface ProductoMapper {

    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "precioUnitario", source = "precio")
    @Mapping(target = "cantidadDisponible", source = "cantidad")
    @Mapping(target = "categoriaId", ignore = true)
    @Mapping(target = "proveedorId", ignore = true)
    public ProductoEntity toEntity(CrearProdutoDTO dto);

    @Mapping(target = "productoId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "precioUnitario", source = "precio")
    @Mapping(target = "cantidadDisponible", source = "cantidad")
    @Mapping(target = "categoriaId", ignore = true)
    @Mapping(target = "proveedorId", ignore = true)
    public ProductoEntity updateToEntity(ActualizarProductoDTO dto, @MappingTarget ProductoEntity entity);

}