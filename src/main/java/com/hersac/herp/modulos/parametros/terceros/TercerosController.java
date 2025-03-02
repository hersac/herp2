package com.hersac.herp.modulos.parametros.terceros;

import com.hersac.herp.modulos.parametros.terceros.dto.ActualizarTerceroDTO;
import com.hersac.herp.modulos.parametros.terceros.dto.CrearTerceroDTO;
import com.hersac.herp.modulos.parametros.terceros.entidades.TerceroEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terceros")
public class TercerosController {
    @Autowired
    private TercerosService tercerosService;

    @GetMapping
    public ResponseEntity<List<TerceroEntity>> buscarTodos() {
        return ResponseEntity.ok(tercerosService.buscarTodos());
    }

    @GetMapping("/{terceroId}")
    public ResponseEntity<TerceroEntity> buscarPorId(@PathVariable Long terceroId) {
        return ResponseEntity.ok(tercerosService.buscarPorId(terceroId));
    }

    @PostMapping
    public ResponseEntity<TerceroEntity> crear(@Valid CrearTerceroDTO dto) {
        return ResponseEntity.ok(tercerosService.crear(dto));
    }

    @PutMapping("/{terceroId}")
    public ResponseEntity<TerceroEntity> actualizar(
            @PathVariable Long terceroId,
            @Valid ActualizarTerceroDTO datosNuevos) {
        tercerosService.actualizar(terceroId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{terceroId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long terceroId) {
        tercerosService.eliminar(terceroId);
        return ResponseEntity.noContent().build();
    }
}
