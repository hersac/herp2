package com.hersac.herp.modulos.nomina.cargos.entidades.repositories;

import com.hersac.herp.modulos.nomina.cargos.entidades.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity, Long> {
}
