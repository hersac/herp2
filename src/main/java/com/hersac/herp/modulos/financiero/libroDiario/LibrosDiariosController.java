package com.hersac.herp.modulos.financiero.libroDiario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.herp.modulos.financiero.libroDiario.dto.ActualizarLibroDiarioDTO;
import com.hersac.herp.modulos.financiero.libroDiario.dto.CrearLibroDiarioDTO;
import com.hersac.herp.modulos.financiero.libroDiario.entities.LibroDiarioEntity;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/libros-diarios")
public class LibrosDiariosController {
    @Autowired
    private LibrosDiariosService librosDiariosService;

    @GetMapping
    public ResponseEntity<List<LibroDiarioEntity>> buscarTodos() {
        return ResponseEntity.ok(librosDiariosService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<LibroDiarioEntity> crear(@Valid @RequestBody CrearLibroDiarioDTO dto) {
        return ResponseEntity.ok(librosDiariosService.crear(dto));
    }

    @GetMapping("/{libroDiarioId}")
    public ResponseEntity<LibroDiarioEntity> buscarPorId(@RequestParam Long libroDiarioId) {
        return ResponseEntity.ok(librosDiariosService.buscarPorId(libroDiarioId));
    }
    
    @PutMapping("/{libroDiarioId}")
    public ResponseEntity<Void> actualizar(
        @PathVariable Long libroDiarioId,
        @Valid @RequestParam ActualizarLibroDiarioDTO nuevosDatos) {
        librosDiariosService.actualizar(libroDiarioId, nuevosDatos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{libroDiarioId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long libroDiarioId) {
        librosDiariosService.eliminar(libroDiarioId);
        return ResponseEntity.ok().build();
    }
    
}
