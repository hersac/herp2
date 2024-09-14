package com.hersac.herp.modulos.comercial.detallesOrdenesCompra.servicesImpl;

import com.hersac.herp.config.exceptions.DetalleOCNotFoundException;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.DetallesOCService;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.ActualizarDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.CrearDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.repositorios.DetalleOCRespository;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.mappers.DetalleOCMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallesOCServiceImpl implements DetallesOCService {
    @Autowired
    private DetalleOCRespository detalleOCRepository;

    @Autowired
    private DetalleOCMappers map;

    public List<DetalleOCEntity> buscarTodos(){
        return detalleOCRepository.findAll();
    }

    public DetalleOCEntity buscarPorId(Long detalleOCId) {
        return detalleOCRepository
                .findById(detalleOCId)
                .orElseThrow(() -> new DetalleOCNotFoundException("El detalle de la orden no existe"));
    }

    public DetalleOCEntity crear(CrearDetalleOCDTO detalleOC) {
        return detalleOCRepository.save(map.toEntity(detalleOC));
    }

    public DetalleOCEntity actualizar(Long detalleOCId, ActualizarDetalleOCDTO datosNuevos) {
        DetalleOCEntity detalleOCExistente  = detalleOCRepository
                .findById(detalleOCId)
                .orElseThrow(() -> new DetalleOCNotFoundException("El detalle de la orden no existe"));

        return detalleOCRepository.save(map.updateToEntity(datosNuevos, detalleOCExistente));
    }

    public void eliminar(Long ordenCompraId){
        detalleOCRepository
                .findById(ordenCompraId)
                .orElseThrow(() -> new DetalleOCNotFoundException("El detalle de la orden no existe"));
        detalleOCRepository.deleteById(ordenCompraId);
    }
}
