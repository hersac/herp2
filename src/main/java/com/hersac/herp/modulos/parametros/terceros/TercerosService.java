package com.hersac.herp.modulos.parametros.terceros;

import com.hersac.herp.modulos.parametros.terceros.dto.ActualizarTerceroDTO;
import com.hersac.herp.modulos.parametros.terceros.dto.CrearTerceroDTO;
import com.hersac.herp.modulos.parametros.terceros.entidades.TerceroEntity;

import java.util.List;

public interface TercerosService {
    public List<TerceroEntity> buscarTodos();
    public TerceroEntity buscarPorId(Long terceroId);
    public TerceroEntity crear(CrearTerceroDTO dto);
    public TerceroEntity actualizar(Long terceroId, ActualizarTerceroDTO datosNuevos);
    public void eliminar(Long terceroId);
}
