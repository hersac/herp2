package com.hersac.herp.modulos.financiero.cuentas.entidades.repositories;

import com.hersac.herp.modulos.financiero.cuentas.entidades.TipoCuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuentaEntity, Long> {
}
