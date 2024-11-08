package com.hersac.herp.modulos.usuarios.usuarios.servicesImpl;

import com.hersac.herp.config.exceptions.usuarios.RolNotFoundException;
import com.hersac.herp.config.exceptions.usuarios.UsuarioNotFoundException;
import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import com.hersac.herp.modulos.usuarios.roles.entities.repositories.RolRepository;
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

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<UsuarioEntity> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity buscarPorId(Long usuarioId){
        return usuarioRepository
                .findById(usuarioId)
                .orElseThrow(() -> new UsuarioNotFoundException("Este usuario no existe"));
    }

    @Override
    public UsuarioEntity crear(CrearUsuarioDTO dto){
        RolEntity rol = rolRepository
                .findById(dto.getRol())
                .orElseThrow(() -> new RolNotFoundException("Este rol no existe"));

        UsuarioEntity usuario = usuarioMapper.toEntity(dto);
        usuario.setRolId(rol);

        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity actualizar(Long usuarioId, ActualizarUsuarioDTO datosNuevos){
        RolEntity rol = rolRepository
                .findById(datosNuevos.getRol())
                .orElseThrow(() -> new RolNotFoundException("Este rol no existe"));

        UsuarioEntity usuarioExistente = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNotFoundException("Este usuario no existe"));

        UsuarioEntity usuarioActualizado = usuarioMapper.updateToEntity(datosNuevos, usuarioExistente);
        usuarioActualizado.setRolId(rol);


        return usuarioRepository.save(usuarioActualizado);
    }

    @Override
    public void eliminar(Long usuarioId){
        usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNotFoundException("Este usuario no existe"));
        usuarioRepository.deleteById(usuarioId);
    }
}
