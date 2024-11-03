package com.hersac.herp.modulos.pos.clientes;

import com.hersac.herp.modulos.pos.clientes.dto.ActualizarClienteDTO;
import com.hersac.herp.modulos.pos.clientes.dto.CrearClienteDTO;
import com.hersac.herp.modulos.pos.clientes.entities.ClienteEntity;

import java.util.List;

public interface ClientesServices {
    public List<ClienteEntity> buscarTodos();
    public ClienteEntity buscarPorId(Long clienteId);
    public ClienteEntity crear(CrearClienteDTO dto);
    public ClienteEntity actualizar(Long clienteId, ActualizarClienteDTO datosNuevos);
    public void eliminar(Long clienteId);
}
