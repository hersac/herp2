package com.hersac.herp.modulos.comercial.ordenesCompra;

import com.hersac.herp.modulos.comercial.ordenesCompra.dto.ActualizarOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.dto.CrearOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes-compras")
public class OrdenesComprasController {

    @Autowired
    private OrdenesComprasService ordenesComprasService;

    @GetMapping
    public ResponseEntity<List<OrdenCompraEntity>> buscarTodos() {
        return ResponseEntity.ok(ordenesComprasService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<OrdenCompraEntity> crear(@Valid @RequestBody CrearOrdenCompraDTO ordenCompra) {
        return ResponseEntity.ok(ordenesComprasService.crear(ordenCompra));
    }

    @GetMapping("/{ordenCompraId}")
    public ResponseEntity<OrdenCompraEntity> buscarPorId(@PathVariable Long ordenCompraId) {
        return ResponseEntity.ok(ordenesComprasService.buscarPorId(ordenCompraId));
    }

    @PutMapping("/{ordenCompraId}")
    public ResponseEntity<Void> actualizar(
            @PathVariable Long ordenCompraId,
            @Valid @RequestBody ActualizarOrdenCompraDTO ordenCompraExistente) {
        ordenesComprasService.actualizar(ordenCompraId, ordenCompraExistente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{ordenCompraId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long ordenCompraId) {
        ordenesComprasService.eliminar(ordenCompraId);
        return ResponseEntity.noContent().build();
    }
}
