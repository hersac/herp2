package com.hersac.herp.modulos.usuarios.usuarios.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioRepository, Long> {
}
