package com.hersac.herp.modulos.comercial.categorias.entidades.repositorios;

import com.hersac.herp.modulos.comercial.categorias.entidades.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
