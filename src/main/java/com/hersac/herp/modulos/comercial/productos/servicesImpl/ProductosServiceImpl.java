package com.hersac.herp.modulos.comercial.productos.servicesImpl;

import com.hersac.herp.modulos.comercial.productos.ProductosService;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import com.hersac.herp.modulos.comercial.productos.entidades.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductosServiceImpl implements ProductosService {
    @Autowired
    private ProductoRepository productosRepository;

    @Override
    public List<ProductoEntity> buscarTodos() {
        return productosRepository.findAll();
    }

    @Override
    public ProductoEntity buscarPorId(Long id) {
        ProductoEntity producto = productosRepository.findById(id).orElse(null);
        if(producto.equals(null)) {
            return null;
        }
        return producto;
    }

    @Override
    public ProductoEntity crear(ProductoEntity producto) {
        ProductoEntity nuevoProducto = productosRepository.save(producto);
        return nuevoProducto;
    }

    @Override
    public ProductoEntity actualizar(Long productoId, ProductoEntity productoExistente) {
        ProductoEntity producto = productosRepository.findById(productoId).orElseThrow();

        productosRepository.save(producto);
        return producto;
    }

    public ResponseEntity<?> eliminar(Long id) {
        productosRepository.deleteById(id);
        Map<String, String> response = Map.of("mensaje", "Producto eliminado correctamente");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
