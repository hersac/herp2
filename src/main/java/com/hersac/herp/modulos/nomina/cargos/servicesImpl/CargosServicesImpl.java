package com.hersac.herp.modulos.nomina.cargos.servicesImpl;

import com.hersac.herp.config.exceptions.nomina.CargoNotFoundException;
import com.hersac.herp.modulos.nomina.cargos.CargosServices;
import com.hersac.herp.modulos.nomina.cargos.dto.ActualizarCargoDTO;
import com.hersac.herp.modulos.nomina.cargos.dto.CrearCargoDTO;
import com.hersac.herp.modulos.nomina.cargos.entidades.CargoEntity;
import com.hersac.herp.modulos.nomina.cargos.entidades.repositories.CargoRepository;
import com.hersac.herp.modulos.nomina.cargos.mappers.CargoMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargosServicesImpl implements CargosServices {
    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CargoMappper cargoMappper;

    public List<CargoEntity> buscarTodos() {
        return cargoRepository.findAll();
    }

    public CargoEntity buscarPorId(Long cargoId){
        return cargoRepository
                .findById(cargoId)
                .orElseThrow(() -> new CargoNotFoundException("Cargo no encontrado"));
    }

    public CargoEntity crear(CrearCargoDTO dto){
        return cargoRepository.save(cargoMappper.toEntity(dto));
    }

    public CargoEntity actualizar(Long cargoId, ActualizarCargoDTO datosNuevos){
        CargoEntity cargo = cargoRepository.findById(cargoId)
                .orElseThrow(() -> new CargoNotFoundException("Cargo no encontrado"));
        return cargoRepository.save(cargoMappper.updateToEntity(datosNuevos, cargo));
    }

    public void eliminar(Long cargoId){
        CargoEntity cargo = cargoRepository.findById(cargoId)
                .orElseThrow(() -> new CargoNotFoundException("Cargo no encontrado"));
        cargoRepository.delete(cargo);
    }
}
