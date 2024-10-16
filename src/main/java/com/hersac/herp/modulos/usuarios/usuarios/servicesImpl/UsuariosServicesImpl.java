package com.hersac.herp.modulos.usuarios.usuarios.servicesImpl;

import com.hersac.herp.config.exceptions.usuarios.UsuarioNotFoundException;
import com.hersac.herp.modulos.usuarios.usuarios.UsuariosServices;
import com.hersac.herp.modulos.usuarios.usuarios.dto.ActualizarUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.dto.CrearUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import com.hersac.herp.modulos.usuarios.usuarios.entities.repositories.UsuarioRepository;
import com.hersac.herp.modulos.usuarios.usuarios.mappers.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServicesImpl implements UsuariosServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<UsuarioEntity> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscarPorId(Long usuarioId){
        return usuarioRepository
                .findById(usuarioId)
                .orElseThrow(() -> new UsuarioNotFoundException("Este usuario no existe"));
    }

    public UsuarioEntity crear(CrearUsuarioDTO dto){
        return usuarioRepository.save(usuarioMapper.toEntity(dto));
    }

    public UsuarioEntity actualizar(Long usuarioId, ActualizarUsuarioDTO datosNuevos){
        UsuarioEntity usuarioExistente = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNotFoundException("Este usuario no existe"));
        return usuarioRepository.save(usuarioMapper.updateToEntity(datosNuevos, usuarioExistente));
    }

    public void eliminar(Long usuarioId){
        usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNotFoundException("Este usuario no existe"));
        usuarioRepository.deleteById(usuarioId);
    }
}
