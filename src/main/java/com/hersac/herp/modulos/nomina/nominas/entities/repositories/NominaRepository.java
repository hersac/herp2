package com.hersac.herp.modulos.nomina.nominas.entities.repositories;

import com.hersac.herp.modulos.nomina.nominas.entities.NominaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominaRepository extends JpaRepository<NominaEntity, Long> {
}
