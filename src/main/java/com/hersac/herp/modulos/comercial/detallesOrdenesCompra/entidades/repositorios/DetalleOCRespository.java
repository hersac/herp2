package com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.repositorios;

import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOCRespository extends JpaRepository<DetalleOCEntity, Long> {
}
