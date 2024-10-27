package com.hersac.herp.modulos.nomina.cargos;

import com.hersac.herp.modulos.nomina.cargos.dto.ActualizarCargoDTO;
import com.hersac.herp.modulos.nomina.cargos.dto.CrearCargoDTO;
import com.hersac.herp.modulos.nomina.cargos.entidades.CargoEntity;

import java.util.List;

public interface CargosServices {
    public List<CargoEntity> buscarTodos();
    public CargoEntity buscarPorId(Long cargoId);
    public CargoEntity crear(CrearCargoDTO dto);
    public CargoEntity actualizar(Long cargoId, ActualizarCargoDTO datosNuevos);
    public void eliminar(Long cargoId);
}
