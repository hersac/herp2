package com.hersac.herp.modulos.financiero.libroDiario.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.herp.config.exceptions.financiero.CuentaNotFoundException;
import com.hersac.herp.config.exceptions.financiero.LibroDiarioNotFoundException;
import com.hersac.herp.modulos.financiero.cuentas.entidades.CuentaEntity;
import com.hersac.herp.modulos.financiero.cuentas.entidades.repositories.CuentaRepository;
import com.hersac.herp.modulos.financiero.libroDiario.LibrosDiariosService;
import com.hersac.herp.modulos.financiero.libroDiario.dto.ActualizarLibroDiarioDTO;
import com.hersac.herp.modulos.financiero.libroDiario.dto.CrearLibroDiarioDTO;
import com.hersac.herp.modulos.financiero.libroDiario.entities.LibroDiarioEntity;
import com.hersac.herp.modulos.financiero.libroDiario.entities.repositories.LibroDiarioRepository;
import com.hersac.herp.modulos.financiero.libroDiario.mappers.LibroDiarioMapper;

@Service
public class LibrosDiariosServiceImpl implements LibrosDiariosService {
    @Autowired
    private LibroDiarioRepository libroDiarioRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private LibroDiarioMapper libroDiarioMapper;

    @Override
    public List<LibroDiarioEntity> buscarTodos(){
        return libroDiarioRepository.findAll();
    }

    @Override
    public LibroDiarioEntity buscarPorId(Long libroDiarioId){
        return libroDiarioRepository.findById(libroDiarioId).orElseThrow(()-> new LibroDiarioNotFoundException("No se encontro el libro diario"));
    }

    @Override
    public LibroDiarioEntity crear(CrearLibroDiarioDTO dto){
        CuentaEntity cuenta = cuentaRepository
        .findById(dto.getCuenta())
        .orElseThrow(() -> new CuentaNotFoundException("No se encontro la cuenta"));

        LibroDiarioEntity libroDiario = libroDiarioMapper.toEntity(dto);
        libroDiario.setCuentaId(cuenta);

        return libroDiarioRepository.save(libroDiario);
    }

    @Override
    public LibroDiarioEntity actualizar(Long libroDiarioId, ActualizarLibroDiarioDTO nuevosDatos){
        CuentaEntity cuenta = cuentaRepository
        .findById(nuevosDatos.getCuenta())
        .orElseThrow(() -> new CuentaNotFoundException("No se encontro la cuenta"));

        LibroDiarioEntity libroDiario = libroDiarioRepository
        .findById(libroDiarioId)
        .orElseThrow(()-> new LibroDiarioNotFoundException("No se encontro el libro diario"));

        libroDiario.setCuentaId(cuenta);

        return libroDiarioRepository.save(libroDiarioMapper.updateToEntity(nuevosDatos, libroDiario));
    }

    @Override
    public void eliminar(Long libroDiarioId){
        libroDiarioRepository.findById(libroDiarioId).orElseThrow(()-> new LibroDiarioNotFoundException("No se encontro el libro diario"));
        libroDiarioRepository.deleteById(libroDiarioId);
    }
}
