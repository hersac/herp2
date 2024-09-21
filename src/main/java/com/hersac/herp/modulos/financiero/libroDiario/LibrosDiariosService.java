package com.hersac.herp.modulos.financiero.libroDiario;

import java.util.List;

import com.hersac.herp.modulos.financiero.libroDiario.dto.ActualizarLibroDiarioDTO;
import com.hersac.herp.modulos.financiero.libroDiario.dto.CrearLibroDiarioDTO;
import com.hersac.herp.modulos.financiero.libroDiario.entities.LibroDiarioEntity;

public interface LibrosDiariosService {
    public List<LibroDiarioEntity> buscarTodos();
    public LibroDiarioEntity buscarPorId(Long libroDiarioId);
    public LibroDiarioEntity crear(CrearLibroDiarioDTO dto);
    public LibroDiarioEntity actualizar(Long libroDiarioId, ActualizarLibroDiarioDTO nuevosDatos);
    public void eliminar(Long libroDiarioId);
}
