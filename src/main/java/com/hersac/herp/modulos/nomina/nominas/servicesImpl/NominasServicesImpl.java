package com.hersac.herp.modulos.nomina.nominas.servicesImpl;

import com.hersac.herp.config.exceptions.nomina.EmpleadoNotFoundException;
import com.hersac.herp.config.exceptions.nomina.NominaNotFoundException;
import com.hersac.herp.modulos.nomina.empleados.entities.EmpleadoEntity;
import com.hersac.herp.modulos.nomina.empleados.entities.repositories.EmpleadoRepository;
import com.hersac.herp.modulos.nomina.nominas.NominasServices;
import com.hersac.herp.modulos.nomina.nominas.dto.ActualizarNominaDTO;
import com.hersac.herp.modulos.nomina.nominas.dto.CrearNominaDTO;
import com.hersac.herp.modulos.nomina.nominas.entities.NominaEntity;
import com.hersac.herp.modulos.nomina.nominas.entities.repositories.NominaRepository;
import com.hersac.herp.modulos.nomina.nominas.mappers.NominaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NominasServicesImpl implements NominasServices {
    @Autowired
    private NominaRepository nominaRepository;

    @Autowired
    private NominaMapper nominaMapper;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<NominaEntity> buscarTodos(){
        return nominaRepository.findAll();
    }

    public NominaEntity buscarPorId(Long nominasId){
        return nominaRepository
                .findById(nominasId)
                .orElseThrow(() -> new NominaNotFoundException("No se encontró la nomina"));
    }

    public NominaEntity guardar(CrearNominaDTO dto){
        EmpleadoEntity empleado = empleadoRepository
                .findById(dto.getEmpleadoId())
                .orElseThrow(() -> new EmpleadoNotFoundException("No se encontró el empleado"));

        NominaEntity nomina = nominaMapper.toEntity(dto);
        nomina.setEmpleadoId(empleado);
        return nominaRepository.save(nomina);
    }

    public NominaEntity actualizar(long nominaId, ActualizarNominaDTO datosNuevos){
        EmpleadoEntity empleado = empleadoRepository
                .findById(datosNuevos.getEmpleadoId())
                .orElseThrow(() -> new EmpleadoNotFoundException("No se encontró el empleado"));

        NominaEntity nomina = nominaRepository
                .findById(nominaId)
                .orElseThrow(() -> new NominaNotFoundException("No se encontró la nomina"));

        NominaEntity nominaActualizada = nominaMapper.updateToEntity(datosNuevos, nomina);
        nominaActualizada.setEmpleadoId(empleado);

        return nominaRepository.save(nominaActualizada);
    }
    public void eliminar(Long nominasId){
        nominaRepository
                .findById(nominasId)
                .orElseThrow(() -> new NominaNotFoundException("No se encontró la nomina"));
        nominaRepository.deleteById(nominasId);
    }
}
