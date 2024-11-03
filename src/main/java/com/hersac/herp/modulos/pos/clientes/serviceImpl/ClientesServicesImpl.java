package com.hersac.herp.modulos.pos.clientes.serviceImpl;

import com.hersac.herp.config.exceptions.pos.ClienteNotFoundException;
import com.hersac.herp.modulos.pos.clientes.ClientesServices;
import com.hersac.herp.modulos.pos.clientes.dto.ActualizarClienteDTO;
import com.hersac.herp.modulos.pos.clientes.dto.CrearClienteDTO;
import com.hersac.herp.modulos.pos.clientes.entities.ClienteEntity;
import com.hersac.herp.modulos.pos.clientes.entities.repositories.ClienteRepository;
import com.hersac.herp.modulos.pos.clientes.mappers.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServicesImpl implements ClientesServices {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteEntity> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity buscarPorId(Long clienteId) {
        return clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));
    }

    @Override
    public ClienteEntity crear(CrearClienteDTO dto) {
        ClienteEntity cliente = clienteMapper.toEntity(dto);
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity actualizar(Long clienteId, ActualizarClienteDTO datosNuevos) {
        ClienteEntity cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));
        ClienteEntity clienteActualizado = clienteMapper.updateToEntity(datosNuevos, cliente);
        return clienteRepository.save(clienteActualizado);
    }

    @Override
    public void eliminar(Long clienteId) {
        clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));
        clienteRepository.deleteById(clienteId);
    }
}
