package com.hersac.herp.modulos.nomina.empleados;

import com.hersac.herp.modulos.nomina.empleados.dto.ActualizarEmpleadoDTO;
import com.hersac.herp.modulos.nomina.empleados.dto.CrearEmpleadoDTO;
import com.hersac.herp.modulos.nomina.empleados.entities.EmpleadoEntity;

import java.util.List;

public interface EmpleadosServices {
    public List<EmpleadoEntity> buscarTodos();
    public EmpleadoEntity buscarPorId(Long id);
    public EmpleadoEntity crear(CrearEmpleadoDTO dto);
    public EmpleadoEntity actualizar(Long id, ActualizarEmpleadoDTO datosNuevos);
    public void eliminar(Long id);
}
