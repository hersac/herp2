package com.hersac.herp.modulos.usuarios.usuarios.servicesImpl;

import com.hersac.herp.modulos.usuarios.usuarios.UsuariosServices;
import com.hersac.herp.modulos.usuarios.usuarios.dto.ActualizarUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.dto.CrearUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import com.hersac.herp.modulos.usuarios.usuarios.entities.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServicesImpl implements UsuariosServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscarPorId(Long usuarioId){
        return usuarioRepository.findById(usuarioId).orElseThrow();
    }

    public UsuarioEntity crear(CrearUsuarioDTO dto){
        return null;
    }

    public UsuarioEntity actualizar(Long usuarioId, ActualizarUsuarioDTO datosNuevos){
        return null;
    }

    public void eliminar(Long usuarioId){

    }
}
