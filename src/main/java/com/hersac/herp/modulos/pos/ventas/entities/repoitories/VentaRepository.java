package com.hersac.herp.modulos.pos.ventas.entities.repoitories;

import com.hersac.herp.modulos.pos.ventas.entities.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long> {
}
