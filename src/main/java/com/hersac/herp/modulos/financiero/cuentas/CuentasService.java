package com.hersac.herp.modulos.financiero.cuentas;

import com.hersac.herp.modulos.financiero.cuentas.dto.ActualizarCuentaDTO;
import com.hersac.herp.modulos.financiero.cuentas.dto.CrearCuentaDTO;
import com.hersac.herp.modulos.financiero.cuentas.entidades.CuentaEntity;

import java.util.List;

public interface CuentasService {
    public List<CuentaEntity> buscarTodos();
    public CuentaEntity buscarPorId(Long cuentaId);
    public CuentaEntity crear(CrearCuentaDTO dto);
    public CuentaEntity actualizar(Long cuentaId, ActualizarCuentaDTO nuevosDatos);
}
