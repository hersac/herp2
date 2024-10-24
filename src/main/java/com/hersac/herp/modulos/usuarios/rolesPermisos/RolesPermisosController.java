package com.hersac.herp.modulos.usuarios.rolesPermisos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rolesPermisos")
public class RolesPermisosController {

    @Autowired
    private RolesPermisosServices rolesPermisosServices;

    @PostMapping("/{rolId}/permisos/{permisoId}")
    public ResponseEntity<String> asignarPermiso(
            @PathVariable Long rolId,
            @PathVariable Long permisoId) {
        rolesPermisosServices.asignarPermiso(rolId, permisoId);
        return ResponseEntity.ok("Permiso asignado correctamente");
    }
}
