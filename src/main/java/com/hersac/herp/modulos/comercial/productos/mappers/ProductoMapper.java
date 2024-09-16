package com.hersac.herp.modulos.comercial.productos.mappers;

import com.hersac.herp.modulos.comercial.categorias.entidades.CategoriaEntity;
import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "precioUnitario", source = "precio")
    @Mapping(target = "cantidadDisponible", source = "cantidad")
    @Mapping(target = "categoriaId", source = "categoria.id", qualifiedByName = "mapCategoria")
    @Mapping(target = "proveedorId", source = "proveedor.id", qualifiedByName = "mapProveedor")
    public ProductoEntity toEntity(CrearProdutoDTO dto);

    @Mapping(target = "productoId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "precioUnitario", source = "precio")
    @Mapping(target = "cantidadDisponible", source = "cantidad")
    @Mapping(target = "categoriaId", source = "categoria.id", qualifiedByName = "mapCategoria")
    @Mapping(target = "proveedorId", source = "proveedor.id", qualifiedByName = "mapProveedor")
    public ProductoEntity updateToEntity(ActualizarProductoDTO dto, @MappingTarget ProductoEntity entity);

    @Named("mapCategoria")
    default CategoriaEntity mapCategoria(Long categoriaId, MappingContext context) {
        return categoriaRepository.findById(categoriaId).orElse(null);
    }

    @Named("mapProveedor")
    default ProveedorEntity mapProveedor(Long proveedorId, MappingContext context) {
        return proveedorRepository.findById(proveedorId).orElse(null);

    }
