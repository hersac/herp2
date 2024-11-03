package com.hersac.herp.modulos.pos.detallesVentas;

import com.hersac.herp.modulos.pos.detallesVentas.dto.ActualizarDetalleVentaDTO;
import com.hersac.herp.modulos.pos.detallesVentas.dto.CrearDetalleVentaDTO;
import com.hersac.herp.modulos.pos.detallesVentas.entities.DetalleVentaEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detallesVentas")
public class DetallesVentasController {
    @Autowired
    private DetallesVentasServices detallesVentasService;

    @GetMapping
    public ResponseEntity<List<DetalleVentaEntity>> buscarTodos() {
        return ResponseEntity.ok(detallesVentasService.buscarTodos());
    }

    @GetMapping("/{detalleVentaId}")
    public ResponseEntity<DetalleVentaEntity> buscarPorId(@PathVariable Long detalleVentaId) {
        return ResponseEntity.ok(detallesVentasService.buscarPorId(detalleVentaId));
    }

    @PostMapping
    public ResponseEntity<DetalleVentaEntity> guardar(@Valid @RequestBody CrearDetalleVentaDTO dto) {
        return ResponseEntity.ok(detallesVentasService.crear(dto));
    }

    @PutMapping("/{detalleVentaId}")
    public ResponseEntity<DetalleVentaEntity> actualizar(
            @PathVariable Long detalleVentaId,
            @Valid @RequestBody ActualizarDetalleVentaDTO datosNuevos) {
        detallesVentasService.actualizar(detalleVentaId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{detalleVentaId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long detalleVentaId) {
        detallesVentasService.eliminar(detalleVentaId);
        return ResponseEntity.noContent().build();
    }

}
