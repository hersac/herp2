package com.hersac.herp.modulos.financiero.transacciones.entidades.repositories;

import com.hersac.herp.modulos.financiero.transacciones.entidades.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<TransaccionEntity, Long> {
}
