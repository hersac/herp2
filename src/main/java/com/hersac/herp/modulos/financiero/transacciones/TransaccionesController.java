package com.hersac.herp.modulos.financiero.transacciones;

import com.hersac.herp.modulos.financiero.transacciones.dto.ActualizarTransaccionesDTO;
import com.hersac.herp.modulos.financiero.transacciones.dto.CrearTransaccionesDTO;
import com.hersac.herp.modulos.financiero.transacciones.entidades.TransaccionEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionesController {
    @Autowired
    private TransaccionesService transaccionesService;

    @GetMapping
    public ResponseEntity<List<TransaccionEntity>> buscarTodos() {
        return ResponseEntity.ok(transaccionesService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<TransaccionEntity> crear(@Valid @RequestBody CrearTransaccionesDTO dto){
        return ResponseEntity.ok(transaccionesService.crear(dto));
    }

    @GetMapping("/{transaccionId}")
    public ResponseEntity<TransaccionEntity> buscarPorId(Long transaccionId){
        return ResponseEntity.ok(transaccionesService.buscarPorId(transaccionId));
    }

    @PutMapping("/{transaccionId}")
    public ResponseEntity<Void> buscarPorId(
            @PathVariable Long transaccionId,
            @Valid @RequestBody ActualizarTransaccionesDTO datosNuevos){
        transaccionesService.actualizar(transaccionId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{transaccionId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long transaccionId){
        transaccionesService.eliminar(transaccionId);
        return ResponseEntity.noContent().build();
    }
}
