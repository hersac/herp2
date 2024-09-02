package com.hersac.herp.modulos.comercial.productos;

import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @GetMapping
    public List<ProductoEntity> buscarTodos() {
        return productosService.buscarTodos();
    }

    @PostMapping
    public ProductoEntity crear(@RequestBody ProductoEntity producto) {
        return productosService.crear(producto);
    }

    @GetMapping("/{productoId}")
    public ProductoEntity buscarPorId(@PathVariable Long productoId) {
        return productosService.buscarPorId(productoId);
    }

    @PutMapping("/{productoId}")
    public ProductoEntity actualizar(@PathVariable Long productoId, @RequestBody ProductoEntity productoExistente) {
        return productosService.actualizar(productoId, productoExistente);
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<?> eliminar(Long productoId) {
        return productosService.eliminar(productoId);
    }
}
