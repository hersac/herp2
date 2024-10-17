package com.hersac.herp.modulos.usuarios.permisos;

import com.hersac.herp.modulos.usuarios.permisos.dto.ActualizarPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.dto.CrearPermisoDTO;
import com.hersac.herp.modulos.usuarios.permisos.entities.PermisoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permisos")
public class PermisosController {
    @Autowired
    private PermisosServices permisosServices;

    public ResponseEntity<List<PermisoEntity>> buscarTodos() {
        return ResponseEntity.ok(permisosServices.buscarTodos());
    }

    public ResponseEntity<PermisoEntity> buscarPorId(Long permisoId) {
        return ResponseEntity.ok(permisosServices.buscarPorId(permisoId));
    }

    public ResponseEntity<PermisoEntity> crear(CrearPermisoDTO dto) {
        return ResponseEntity.ok(permisosServices.crear(dto));
    }

    public ResponseEntity<Void> actualizar(Long permisoId, ActualizarPermisoDTO datosNuevos) {
        permisosServices.actualizar(permisoId, datosNuevos);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> eliminar(Long permisoId) {
        permisosServices.eliminar(permisoId);
        return ResponseEntity.noContent().build();
    }
}
