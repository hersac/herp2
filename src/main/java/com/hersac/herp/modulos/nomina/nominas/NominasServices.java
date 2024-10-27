package com.hersac.herp.modulos.nomina.nominas;

import com.hersac.herp.modulos.nomina.nominas.dto.ActualizarNominaDTO;
import com.hersac.herp.modulos.nomina.nominas.dto.CrearNominaDTO;
import com.hersac.herp.modulos.nomina.nominas.entities.NominaEntity;

import java.util.List;

public interface NominasServices {
    public List<NominaEntity> buscarTodos();
    public NominaEntity buscarPorId(Long nominasId);
    public NominaEntity guardar(CrearNominaDTO dto);
    public NominaEntity actualizar(long nominaId, ActualizarNominaDTO datosNuevos);
    public void eliminar(Long nominasId);
}
