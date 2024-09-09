package com.hersac.herp.modulos.comercial.proveedores;

import com.hersac.herp.modulos.comercial.proveedores.dto.ActualizarProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.dto.CrearProveedorDTO;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedoresService proveedoresService;

    @GetMapping
    public ResponseEntity<List<ProveedorEntity>> getProveedores() {
        return ResponseEntity.ok(proveedoresService.buscarTodos());
    }

    @GetMapping("/{id")
    public String getProveedor(@PathVariable Long id) {
        return "Proveedor";
    }

    @PostMapping
    public String postProveedor(@RequestBody CrearProveedorDTO proveedor) {
        return "Proveedor creado";
    }

    @PutMapping("/{id}")
    public String putProveedor(@PathVariable Long id, @RequestBody ActualizarProveedorDTO proveedor) {
        return "Proveedor actualizado";
    }

    @DeleteMapping("/{id}")
    public String deleteProveedor(@PathVariable Long id) {
        return "Proveedor eliminado";
    }
}
