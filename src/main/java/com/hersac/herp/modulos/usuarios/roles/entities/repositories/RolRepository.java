package com.hersac.herp.modulos.usuarios.roles.entities.repositories;

import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {
}
