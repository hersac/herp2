package com.hersac.herp.modulos.parametros.terceros;

import com.hersac.herp.modulos.parametros.terceros.entidades.TerceroEntity;

import java.util.List;

public interface TercerosService {
    public List<TerceroEntity> buscarTodos();
    public TerceroEntity buscarPorId(Long terceroId);
    public TerceroEntity crear(TerceroEntity tercero);
    public TerceroEntity actualizar(Long terceroId, TerceroEntity tercero);
    public void eliminar(Long terceroId);
}
