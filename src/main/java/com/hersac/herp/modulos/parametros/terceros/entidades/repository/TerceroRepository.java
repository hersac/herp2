package com.hersac.herp.modulos.parametros.terceros.entidades.repository;

import com.hersac.herp.modulos.parametros.terceros.entidades.TerceroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerceroRepository extends JpaRepository<TerceroEntity, Long> {
}
