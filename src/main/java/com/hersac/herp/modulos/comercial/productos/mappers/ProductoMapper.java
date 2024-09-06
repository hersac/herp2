package com.hersac.herp.modulos.comercial.productos.mappers;

import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public ProductoEntity toEntity(CrearProdutoDTO dto) {
        ProductoEntity producto = new ProductoEntity();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecioUnitario(dto.getPrecioUnitario());
        producto.setCantidadDisponible(dto.getCantidadDisponible());
        producto.setCategoriaId(dto.getCategoriaId());
        producto.setProveedorId(dto.getProveedorId());
        return producto;
    }
}
