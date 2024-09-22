package com.hersac.herp.modulos.financiero.cuentas;

import com.hersac.herp.modulos.financiero.cuentas.dto.ActualizarCuentaDTO;
import com.hersac.herp.modulos.financiero.cuentas.dto.CrearCuentaDTO;
import com.hersac.herp.modulos.financiero.cuentas.entidades.CuentaEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {
    @Autowired
    private CuentasService cuentasService;

    @GetMapping
    public ResponseEntity<List<CuentaEntity>> buscarTodos() {
        return ResponseEntity.ok(cuentasService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<CuentaEntity> crear(@Valid @RequestBody CrearCuentaDTO dto) {
        return ResponseEntity.ok(cuentasService.crear(dto));
    }

    @GetMapping("/{cuentaId}")
    public ResponseEntity<CuentaEntity> buscarPorId(@PathVariable Long cuentaId) {
        return ResponseEntity.ok(cuentasService.buscarPorId(cuentaId));
    }

    @PutMapping("/{cuentaId}")
    public ResponseEntity<Void> actualizar(
            @PathVariable Long cuentaId,
            @Valid @RequestBody ActualizarCuentaDTO datosNuevos) {
        cuentasService.actualizar(cuentaId, datosNuevos);
        return ResponseEntity.noContent().build();
    }
}
