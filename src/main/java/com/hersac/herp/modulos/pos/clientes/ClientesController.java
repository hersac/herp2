package com.hersac.herp.modulos.pos.clientes;

import com.hersac.herp.modulos.pos.clientes.dto.ActualizarClienteDTO;
import com.hersac.herp.modulos.pos.clientes.dto.CrearClienteDTO;
import com.hersac.herp.modulos.pos.clientes.entities.ClienteEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesServices clientesService;

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> buscarTodos() {
        return ResponseEntity.ok(clientesService.buscarTodos());
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteEntity> buscarPorId(@PathVariable Long clienteId) {
        return ResponseEntity.ok(clientesService.buscarPorId(clienteId));
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> crear(@Valid @RequestBody CrearClienteDTO dto) {
        return ResponseEntity.ok(clientesService.crear(dto));
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteEntity> actualizar(
            @PathVariable Long clienteId,
            @Valid @RequestBody ActualizarClienteDTO datosNuevos) {
        clientesService.actualizar(clienteId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long clienteId) {
        clientesService.eliminar(clienteId);
        return ResponseEntity.noContent().build();
    }
}
