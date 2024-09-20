package com.hersac.herp.modulos.financiero.cuentas.mappers;

import com.hersac.herp.modulos.financiero.cuentas.dto.ActualizarCuentaDTO;
import com.hersac.herp.modulos.financiero.cuentas.dto.CrearCuentaDTO;
import com.hersac.herp.modulos.financiero.cuentas.entidades.CuentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CuentaMapper {

    @Mapping(target = "cuentaId", ignore = true)
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "saldo", source = "saldo")
    @Mapping(target = "tipoCuentaId", ignore = true)
    public CuentaEntity toEntity(CrearCuentaDTO dto);

    @Mapping(target = "cuentaId", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "saldo", source = "saldo")
    @Mapping(target = "tipoCuentaId", ignore = true)
    public CuentaEntity updateToEntity(ActualizarCuentaDTO dto, @MappingTarget CuentaEntity entity);
}
