package com.hersac.herp.modulos.comercial.categorias.servicesImpl;

import com.hersac.herp.config.exceptions.comercial.CategoriaNotFoundException;
import com.hersac.herp.modulos.comercial.categorias.CategoriasService;
import com.hersac.herp.modulos.comercial.categorias.dto.ActualizarCategoriaDTO;
import com.hersac.herp.modulos.comercial.categorias.dto.CrearCategoriaDTO;
import com.hersac.herp.modulos.comercial.categorias.entidades.CategoriaEntity;
import com.hersac.herp.modulos.comercial.categorias.entidades.repositorios.CategoriaRepository;
import com.hersac.herp.modulos.comercial.categorias.mappers.CategoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasServiceImpl implements CategoriasService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper map;

    public List<CategoriaEntity> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public CategoriaEntity buscarPorId(Long categoriaId) {
        return categoriaRepository
                .findById(categoriaId)
                .orElseThrow(() -> new CategoriaNotFoundException("La categoría no existe"));
    }

    public CategoriaEntity crear(CrearCategoriaDTO categoria) {
        return categoriaRepository.save(map.toEntity(categoria));
    }

    public CategoriaEntity actualizar(Long categoriaId, ActualizarCategoriaDTO datosNuevos) {
        CategoriaEntity categoriaExistente  = categoriaRepository
                .findById(categoriaId)
                .orElseThrow(() -> new CategoriaNotFoundException("La categoría no existe"));

        return categoriaRepository.save(map.updateToEntity(datosNuevos, categoriaExistente));
    }

    public void eliminar(Long categoriaId){
        categoriaRepository
                .findById(categoriaId)
                .orElseThrow(() -> new CategoriaNotFoundException("La categoría no existe"));
        categoriaRepository.deleteById(categoriaId);
    }
}
