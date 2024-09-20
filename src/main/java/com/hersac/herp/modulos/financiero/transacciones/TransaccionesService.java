package com.hersac.herp.modulos.financiero.transacciones;

import com.hersac.herp.modulos.financiero.transacciones.dto.ActualizarTransaccionesDTO;
import com.hersac.herp.modulos.financiero.transacciones.dto.CrearTransaccionesDTO;
import com.hersac.herp.modulos.financiero.transacciones.entidades.TransaccionEntity;

import java.util.List;

public interface TransaccionesService {
    public List<TransaccionEntity> buscarTodos();
    public TransaccionEntity buscarPorId(Long transaccionId);
    public TransaccionEntity crear(CrearTransaccionesDTO dto);
    public TransaccionEntity actualizar(Long transaccionId, ActualizarTransaccionesDTO transaccion);
    public void eliminar(Long transaccionId);
}
