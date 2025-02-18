package com.hersac.herp.modulos.parametros.terceros.mappers;

import com.hersac.herp.modulos.parametros.terceros.dto.ActualizarTerceroDTO;
import com.hersac.herp.modulos.parametros.terceros.dto.CrearTerceroDTO;
import com.hersac.herp.modulos.parametros.terceros.entidades.TerceroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TerceroMapper {

    @Mapping(target = "terceroId", ignore = true)
    @Mapping(target = "razonSocial", source = "razonSocial")
    @Mapping(target = "nit", source = "nit")
    @Mapping(target = "direccion", source = "direccion")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "contacto", source = "contacto")
    @Mapping(target = "esNatural", ignore = true)
    public TerceroEntity toEntity(CrearTerceroDTO dto);

    @Mapping(target = "terceroId", ignore = true)
    @Mapping(target = "razonSocial", source = "razonSocial")
    @Mapping(target = "nit", source = "nit")
    @Mapping(target = "direccion", source = "direccion")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "contacto", source = "contacto")
    @Mapping(target = "esNatural", ignore = true)
    public TerceroEntity updateToEntity(ActualizarTerceroDTO dto, @MappingTarget TerceroEntity entity);
}
