package com.hersac.herp.modulos.pos.detallesVentas.entities.repositories;

import com.hersac.herp.modulos.pos.detallesVentas.entities.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Long> {
}
