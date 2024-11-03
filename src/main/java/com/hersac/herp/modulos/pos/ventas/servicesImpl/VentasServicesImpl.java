package com.hersac.herp.modulos.pos.ventas.servicesImpl;

import com.hersac.herp.config.exceptions.pos.ClienteNotFoundException;
import com.hersac.herp.config.exceptions.pos.VentaNotFoundException;
import com.hersac.herp.config.exceptions.usuarios.UsuarioNotFoundException;
import com.hersac.herp.modulos.pos.clientes.entities.ClienteEntity;
import com.hersac.herp.modulos.pos.clientes.entities.repositories.ClienteRepository;
import com.hersac.herp.modulos.pos.ventas.VentasServices;
import com.hersac.herp.modulos.pos.ventas.dto.ActualizarVentaDTO;
import com.hersac.herp.modulos.pos.ventas.dto.CrearVentaDTO;
import com.hersac.herp.modulos.pos.ventas.entities.VentaEntity;
import com.hersac.herp.modulos.pos.ventas.entities.repoitories.VentaRepository;
import com.hersac.herp.modulos.pos.ventas.mappers.VentaMapper;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import com.hersac.herp.modulos.usuarios.usuarios.entities.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServicesImpl implements VentasServices {
    @Autowired
    private VentaRepository ventasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VentaMapper ventaMapper;

    @Override
    public List<VentaEntity> buscarTodos(){
        return ventasRepository.findAll();
    }

    @Override
    public VentaEntity buscarPorId(Long ventaId){
        return ventasRepository
                .findById(ventaId)
                .orElseThrow(()->new VentaNotFoundException("Venta no encontrada"));
    }

    @Override
    public VentaEntity crear(CrearVentaDTO dto){
        ClienteEntity cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado"));
        UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(()->new UsuarioNotFoundException("Usuario no encontrado"));
        VentaEntity venta = ventaMapper.toEntity(dto);
        venta.setClienteId(cliente);
        venta.setUsuarioId(usuario);

        return ventasRepository.save(venta);
    }

    @Override
    public VentaEntity actualizar(Long ventaId, ActualizarVentaDTO datosNuevos){
        ClienteEntity cliente = clienteRepository.findById(datosNuevos.getClienteId())
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado"));
        UsuarioEntity usuario = usuarioRepository.findById(datosNuevos.getUsuarioId())
                .orElseThrow(()->new UsuarioNotFoundException("Usuario no encontrado"));
        VentaEntity ventaExistente = ventasRepository.findById(ventaId)
                .orElseThrow(()->new VentaNotFoundException("Venta no encontrada"));
        VentaEntity ventaActualizada = ventaMapper.updateToEntity(datosNuevos, ventaExistente);
        ventaActualizada.setClienteId(cliente);
        ventaActualizada.setUsuarioId(usuario);
        return ventasRepository.save(ventaActualizada);
    }

    @Override
    public void eliminar(Long ventaId){
        ventasRepository.findById(ventaId)
                .orElseThrow(()->new VentaNotFoundException("Venta no encontrada"));
        ventasRepository.deleteById(ventaId);
    }
}
