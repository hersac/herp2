package com.hersac.herp.modulos.comercial.detallesOrdenesCompra;

import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.ActualizarDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.CrearDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles-oc")
public class DetallesOCController {
    @Autowired
    private DetallesOCService detallesOCService;

    @GetMapping
    public ResponseEntity<List<DetalleOCEntity>> buscarTodos() {
        return ResponseEntity.ok(detallesOCService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<DetalleOCEntity> crear(@Valid @RequestBody CrearDetalleOCDTO detallesOC) {
        return ResponseEntity.ok(detallesOCService.crear(detallesOC));
    }

    @GetMapping("/{detalleOCId}")
    public ResponseEntity<DetalleOCEntity> buscarPorId(@PathVariable Long detalleOCId) {
        return ResponseEntity.ok(detallesOCService.buscarPorId(detalleOCId));
    }

    @PutMapping("/{detalleOCId}")
    public ResponseEntity<Void> actualizar(
            @PathVariable Long detalleOCId,
            @Valid @RequestBody ActualizarDetalleOCDTO detallesOCExistente) {
        detallesOCService.actualizar(detalleOCId, detallesOCExistente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{detalleOCId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long detalleOCId) {
        detallesOCService.eliminar(detalleOCId);
        return ResponseEntity.noContent().build();
    }
}
