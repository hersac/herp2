package com.hersac.herp.modulos.comercial.productos.entidades.repositorios;

import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
