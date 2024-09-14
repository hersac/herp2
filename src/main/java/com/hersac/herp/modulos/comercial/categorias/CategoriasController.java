package com.hersac.herp.modulos.comercial.categorias;

import com.hersac.herp.modulos.comercial.categorias.dto.ActualizarCategoriaDTO;
import com.hersac.herp.modulos.comercial.categorias.dto.CrearCategoriaDTO;
import com.hersac.herp.modulos.comercial.categorias.entidades.CategoriaEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> buscarTodos() {
        return ResponseEntity.ok(categoriasService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<CategoriaEntity> crear(@Valid @RequestBody CrearCategoriaDTO categoria) {
        return ResponseEntity.ok(categoriasService.crear(categoria));
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriaEntity> buscarPorId(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(categoriasService.buscarPorId(categoriaId));
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<Void> actualizar(
            @PathVariable Long categoriaId,
            @Valid @RequestBody ActualizarCategoriaDTO datosNuevos) {
        categoriasService.actualizar(categoriaId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long categoriaId) {
        categoriasService.eliminar(categoriaId);
        return ResponseEntity.noContent().build();
    }
}
