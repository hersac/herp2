package com.hersac.herp.modulos.comercial.proveedores;

import com.hersac.herp.modulos.comercial.proveedores.dto.ActualizarProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.dto.CrearProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedoresService proveedoresService;

    @GetMapping
    public ResponseEntity<List<ProveedorEntity>> buscarTodos() {
        return ResponseEntity.ok(proveedoresService.buscarTodos());
    }

    @GetMapping("/{proveedorId}")
    public ResponseEntity<ProveedorEntity> buscarPorId(@PathVariable Long proveedorId) {
        return ResponseEntity.ok(proveedoresService.buscarPorId(proveedorId));
    }

    @PostMapping
    public ResponseEntity<ProveedorEntity> crear(@Valid @RequestBody CrearProveedorDTO proveedor) {

        return ResponseEntity.ok(proveedoresService.crear(proveedor));
    }

    @PutMapping("/{proveedorId}")
    public ResponseEntity<Void> actualizar(@Valid @PathVariable Long proveedorId, @RequestBody ActualizarProveedorDTO proveedor) {
        proveedoresService.actualizar(proveedorId, proveedor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{proveedorId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long proveedorId) {
        proveedoresService.eliminar(proveedorId);
        return ResponseEntity.noContent().build();
    }
}
