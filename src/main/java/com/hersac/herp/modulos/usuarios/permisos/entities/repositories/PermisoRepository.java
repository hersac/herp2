package com.hersac.herp.modulos.usuarios.permisos.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.herp.modulos.usuarios.permisos.entities.PermisoEntity;

@Repository
public interface PermisoRepository extends JpaRepository<PermisoEntity, Long>{
}
