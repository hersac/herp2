package com.hersac.herp.modulos.pos.ventas.servicesImpl;

import com.hersac.herp.config.exceptions.pos.VentaNotFoundException;
import com.hersac.herp.modulos.pos.ventas.VentasServices;
import com.hersac.herp.modulos.pos.ventas.dto.ActualizarVentaDTO;
import com.hersac.herp.modulos.pos.ventas.dto.CrearVentaDTO;
import com.hersac.herp.modulos.pos.ventas.entities.VentaEntity;
import com.hersac.herp.modulos.pos.ventas.entities.repoitories.VentaRepository;
import com.hersac.herp.modulos.pos.ventas.mappers.VentaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServicesImpl implements VentasServices {
    @Autowired
    private VentaRepository ventasRepository;

    @Autowired
    private VentaMapper ventaMapper;

    public List<VentaEntity> buscarTodos(){
        return ventasRepository.findAll();
    }

    public VentaEntity buscarPorId(Long ventaId){
        return ventasRepository
                .findById(ventaId)
                .orElseThrow(()->new VentaNotFoundException("Venta no encontrada"));
    }

    public VentaEntity crear(CrearVentaDTO dto){

    }
    public VentaEntity actualizar(Long ventaId, ActualizarVentaDTO datosNuevos){

    }
    public void eliminar(Long ventaId){

    }
}
