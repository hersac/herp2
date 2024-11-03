package com.hersac.herp.modulos.pos.ventas;

import com.hersac.herp.modulos.pos.ventas.dto.ActualizarVentaDTO;
import com.hersac.herp.modulos.pos.ventas.dto.CrearVentaDTO;
import com.hersac.herp.modulos.pos.ventas.entities.VentaEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    private VentasServices ventasServices;

    @GetMapping
    public ResponseEntity<List<VentaEntity>> buscarTodos(){
        return ResponseEntity.ok(ventasServices.buscarTodos());
    }

    @GetMapping("/{ventaId}")
    public ResponseEntity<VentaEntity> buscarPorId(@PathVariable Long ventaId){
        return ResponseEntity.ok(ventasServices.buscarPorId(ventaId));
    }

    @PostMapping
    public ResponseEntity<VentaEntity> crear(@RequestBody CrearVentaDTO dto){
        return ResponseEntity.ok(ventasServices.crear(dto));
    }

    @PutMapping("/{ventaId}")
    public ResponseEntity<Void> actualizar(@PathVariable Long ventaId, @Valid @RequestBody ActualizarVentaDTO datosNuevos){
        ventasServices.actualizar(ventaId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{ventaId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long ventaId){
        ventasServices.eliminar(ventaId);
        return ResponseEntity.noContent().build();
    }
}
