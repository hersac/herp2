package com.hersac.herp.modulos.financiero.libroDiario.entities.repositories;

import com.hersac.herp.modulos.financiero.libroDiario.entities.LibroDiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroDiarioRepository extends JpaRepository<LibroDiarioEntity, Long> {
}
