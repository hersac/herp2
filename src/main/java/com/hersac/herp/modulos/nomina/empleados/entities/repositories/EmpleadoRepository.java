package com.hersac.herp.modulos.nomina.empleados.entities.repositories;

import com.hersac.herp.modulos.nomina.empleados.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
}
