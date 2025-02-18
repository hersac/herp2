package com.hersac.herp.modulos.parametros.terceros.servicesImpl;

import com.hersac.herp.config.exceptions.parametros.terceros.TerceroNotFoundException;
import com.hersac.herp.modulos.parametros.terceros.TercerosService;
import com.hersac.herp.modulos.parametros.terceros.dto.ActualizarTerceroDTO;
import com.hersac.herp.modulos.parametros.terceros.dto.CrearTerceroDTO;
import com.hersac.herp.modulos.parametros.terceros.entidades.TerceroEntity;
import com.hersac.herp.modulos.parametros.terceros.entidades.repository.TerceroRepository;
import com.hersac.herp.modulos.parametros.terceros.mappers.TerceroMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TercerosServiceImpl implements TercerosService {
    @Autowired
    private TerceroRepository terceroRepository;

    @Autowired
    private TerceroMapper terceroMapper;

    @Override
    public List<TerceroEntity> buscarTodos(){
        return terceroRepository.findAll();
    }

    @Override
    public TerceroEntity buscarPorId(Long terceroId) {
        return terceroRepository
                .findById(terceroId)
                .orElseThrow(() -> new TerceroNotFoundException("Tercero no encontrado"));
    }

    @Override
    public TerceroEntity crear(CrearTerceroDTO dto){
        TerceroEntity tercero = terceroMapper.toEntity(dto);
        return terceroRepository.save(tercero);
    }

    @Override
    public TerceroEntity actualizar(Long terceroId, ActualizarTerceroDTO tercero) {
        TerceroEntity terceroEntity = terceroRepository
                .findById(terceroId)
                .orElseThrow(() -> new TerceroNotFoundException("Tercero no encontrado"));
        TerceroEntity terceroActualizado = terceroMapper.updateToEntity(tercero, terceroEntity);
        return terceroRepository.save(terceroActualizado);
    }

    @Override
    public void eliminar(Long terceroId) {
        terceroRepository
                .findById(terceroId)
                .orElseThrow(() -> new TerceroNotFoundException("Tercero no encontrado"));
        terceroRepository.deleteById(terceroId);
    }
}
