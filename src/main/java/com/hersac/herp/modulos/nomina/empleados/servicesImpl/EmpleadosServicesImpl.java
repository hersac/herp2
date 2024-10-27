package com.hersac.herp.modulos.nomina.empleados.servicesImpl;

import com.hersac.herp.config.exceptions.nomina.CargoNotFoundException;
import com.hersac.herp.config.exceptions.nomina.EmpleadoNotFoundException;
import com.hersac.herp.modulos.nomina.cargos.entidades.CargoEntity;
import com.hersac.herp.modulos.nomina.cargos.entidades.repositories.CargoRepository;
import com.hersac.herp.modulos.nomina.cargos.mappers.CargoMappper;
import com.hersac.herp.modulos.nomina.empleados.EmpleadosServices;
import com.hersac.herp.modulos.nomina.empleados.dto.ActualizarEmpleadoDTO;
import com.hersac.herp.modulos.nomina.empleados.dto.CrearEmpleadoDTO;
import com.hersac.herp.modulos.nomina.empleados.entities.EmpleadoEntity;
import com.hersac.herp.modulos.nomina.empleados.entities.repositories.EmpleadoRepository;
import com.hersac.herp.modulos.nomina.empleados.mappers.EmpleadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadosServicesImpl implements EmpleadosServices {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private EmpleadoMapper empleadoMapper;

    @Override
    public List<EmpleadoEntity> buscarTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoEntity buscarPorId(Long id) {
        return empleadoRepository.findById(id).orElseThrow(() -> new EmpleadoNotFoundException("Empleado no encontrado"));
    }

    @Override
    public EmpleadoEntity crear(CrearEmpleadoDTO dto) {
        CargoEntity cargo = cargoRepository
                .findById(dto.getCargoId())
                .orElseThrow(() -> new CargoNotFoundException("Cargo no encontrado"));

        EmpleadoEntity empleado = empleadoMapper.toEntity(dto);
        empleado.setCargoId(cargo);

        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity actualizar(Long id, ActualizarEmpleadoDTO datosNuevos) {
        EmpleadoEntity empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException("Empleado no encontrado"));

        CargoEntity cargo = cargoRepository
                .findById(datosNuevos.getCargoId())
                .orElseThrow(() -> new CargoNotFoundException("Cargo no encontrado"));

        empleado.setCargoId(cargo);

        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(Long id) {
        EmpleadoEntity empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException("Empleado no encontrado"));

        empleadoRepository.delete(empleado);
    }
}
