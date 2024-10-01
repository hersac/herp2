package com.hersac.herp.modulos.usuarios.usuarios;

import com.hersac.herp.modulos.usuarios.usuarios.dto.ActualizarUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.dto.CrearUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;

import java.util.List;

public interface UsuariosServices {
    public List<UsuarioEntity> buscarTodos();
    public UsuarioEntity buscarPorId(Long usuarioId);
    public UsuarioEntity crear(CrearUsuarioDTO dto);
    public UsuarioEntity actualizar(Long usuarioId, ActualizarUsuarioDTO datosNuevos);
    public void eliminar(Long usuarioId);
}
