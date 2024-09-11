package com.hersac.herp.modulos.comercial.ordenesCompra.entidades.repositorios;

import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompraEntity, Long> {
}
