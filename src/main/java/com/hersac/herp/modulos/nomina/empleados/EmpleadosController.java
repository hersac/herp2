package com.hersac.herp.modulos.nomina.empleados;

import com.hersac.herp.modulos.nomina.empleados.dto.ActualizarEmpleadoDTO;
import com.hersac.herp.modulos.nomina.empleados.dto.CrearEmpleadoDTO;
import com.hersac.herp.modulos.nomina.empleados.entities.EmpleadoEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
    @Autowired
    private EmpleadosServices empleadosServices;

    @GetMapping
    public ResponseEntity<List<EmpleadoEntity>> buscarTodos() {
        return ResponseEntity.ok(empleadosServices.buscarTodos());
    }

    @GetMapping("/{empleadoId}")
    public ResponseEntity<EmpleadoEntity> obtenerEmpleado(@PathVariable Long empleadoId) {
        return ResponseEntity.ok(empleadosServices.buscarPorId(empleadoId));
    }

    @PostMapping
    public ResponseEntity<EmpleadoEntity> crear(@Valid @RequestBody CrearEmpleadoDTO dto) {
        return ResponseEntity.ok(empleadosServices.crear(dto));
    }

    @PutMapping("/{empleadoId}")
    public ResponseEntity<Void> actualizar(
            @PathVariable Long empleadoId,
            @Valid @RequestBody ActualizarEmpleadoDTO datosNuevos) {
        empleadosServices.actualizar(empleadoId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{empleadoId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long empleadoId) {
        empleadosServices.eliminar(empleadoId);
        return ResponseEntity.noContent().build();
    }
}
