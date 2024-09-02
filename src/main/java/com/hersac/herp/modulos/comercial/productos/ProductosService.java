package com.hersac.herp.modulos.comercial.productos;

import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductosService {
    public List<ProductoEntity> buscarTodos();
    public ProductoEntity buscarPorId(Long id);
    public ProductoEntity crear(ProductoEntity producto);
    public ProductoEntity actualizar(Long productoId, ProductoEntity producto);
    public ResponseEntity<?> eliminar(Long id);
}
