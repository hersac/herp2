package com.hersac.herp.modulos.usuarios.rolesPermisos.entities.respositories;

import com.hersac.herp.modulos.usuarios.rolesPermisos.entities.RolPermisoEntity;
import com.hersac.herp.modulos.usuarios.rolesPermisos.entities.RolPermisoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolPermisoRepository extends JpaRepository<RolPermisoEntity, RolPermisoId> {
}
