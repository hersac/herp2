package com.hersac.herp.modulos.comercial.productos;

import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<ProductoEntity>> buscarTodos() {
        return ResponseEntity.ok(productosService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<ProductoEntity> crear(@Valid @RequestBody CrearProdutoDTO producto) {
        return ResponseEntity.ok(productosService.crear(producto));
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<ProductoEntity> buscarPorId(@PathVariable Long productoId) {
        return ResponseEntity.ok(productosService.buscarPorId(productoId));
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<Void> actualizar(
            @PathVariable Long productoId,
            @Valid @RequestBody ActualizarProductoDTO datosNuevos) {
        productosService.actualizar(productoId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long productoId) {
        productosService.eliminar(productoId);
        return ResponseEntity.noContent().build();
    }
}
