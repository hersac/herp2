package com.hersac.herp.modulos.usuarios.usuarios;

import com.hersac.herp.modulos.usuarios.usuarios.dto.ActualizarUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.dto.CrearUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosServices usuariosServices;

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> buscarTodos() {
        return ResponseEntity.ok(usuariosServices.buscarTodos());
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioEntity> buscarPorId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(usuariosServices.buscarPorId(usuarioId));
    }

    @PostMapping
    public ResponseEntity<UsuarioEntity> crear(@RequestBody CrearUsuarioDTO dto) {
        return ResponseEntity.ok(usuariosServices.crear(dto));
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Void> actualizar(@PathVariable Long usuarioId, @RequestBody ActualizarUsuarioDTO datosNuevos) {
        usuariosServices.actualizar(usuarioId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long usuarioId) {
        usuariosServices.eliminar(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
