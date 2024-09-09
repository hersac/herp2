package com.hersac.herp.modulos.comercial.productos;

import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductosService {
    public List<ProductoEntity> buscarTodos();
    public ProductoEntity buscarPorId(Long id);
    public ProductoEntity crear(CrearProdutoDTO producto);
    public ProductoEntity actualizar(Long productoId, ActualizarProductoDTO producto);
    public void eliminar(Long id);
}
