package com.hersac.herp.modulos.comercial.categorias.mappers;

import com.hersac.herp.modulos.comercial.categorias.dto.ActualizarCategoriaDTO;
import com.hersac.herp.modulos.comercial.categorias.dto.CrearCategoriaDTO;
import com.hersac.herp.modulos.comercial.categorias.entidades.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(target = "categoriaId", ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    public CategoriaEntity toEntity(CrearCategoriaDTO dto);

    @Mapping(target = "categoriaId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    public CategoriaEntity updateToEntity(ActualizarCategoriaDTO dto, @MappingTarget CategoriaEntity entity);
}
