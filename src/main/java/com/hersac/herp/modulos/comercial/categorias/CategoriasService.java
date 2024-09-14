package com.hersac.herp.modulos.comercial.categorias;

import com.hersac.herp.modulos.comercial.categorias.dto.ActualizarCategoriaDTO;
import com.hersac.herp.modulos.comercial.categorias.dto.CrearCategoriaDTO;
import com.hersac.herp.modulos.comercial.categorias.entidades.CategoriaEntity;

import java.util.List;

public interface CategoriasService {
    public List<CategoriaEntity> buscarTodos();
    public CategoriaEntity buscarPorId(Long categoriaId);
    public CategoriaEntity crear(CrearCategoriaDTO categoria);
    public CategoriaEntity actualizar(Long categoriaId, ActualizarCategoriaDTO datosNuevos);
    public void eliminar(Long categoriaId);
}
