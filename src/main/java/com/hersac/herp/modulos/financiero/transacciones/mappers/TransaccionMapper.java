package com.hersac.herp.modulos.financiero.transacciones.mappers;

import com.hersac.herp.modulos.financiero.transacciones.dto.ActualizarTransaccionesDTO;
import com.hersac.herp.modulos.financiero.transacciones.dto.CrearTransaccionesDTO;
import com.hersac.herp.modulos.financiero.transacciones.entidades.TransaccionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TransaccionMapper {

    @Mapping(target = "transaccionId", ignore = true)
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "monto", source = "monto")
    @Mapping(target = "tipoTransaccionId", ignore = true)
    @Mapping(target = "cuentaId", ignore = true)
    public TransaccionEntity toEntity(CrearTransaccionesDTO dto);

    @Mapping(target = "transaccionId", source = "id")
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "monto", source = "monto")
    @Mapping(target = "tipoTransaccionId", ignore = true)
    @Mapping(target = "cuentaId", ignore = true)
    public TransaccionEntity updateToEntity(ActualizarTransaccionesDTO datosNuevos, @MappingTarget TransaccionEntity entity);
}
