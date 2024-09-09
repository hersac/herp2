package com.hersac.herp.modulos.comercial.proveedores.entidades.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
}
