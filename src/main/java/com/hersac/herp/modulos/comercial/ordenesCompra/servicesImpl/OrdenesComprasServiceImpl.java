package com.hersac.herp.modulos.comercial.ordenesCompra.servicesImpl;

import com.hersac.herp.config.exceptions.OrdenCompraNotFound;
import com.hersac.herp.modulos.comercial.ordenesCompra.OrdenesComprasService;
import com.hersac.herp.modulos.comercial.ordenesCompra.dto.ActualizarOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.dto.CrearOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.repositorios.OrdenCompraRepository;
import com.hersac.herp.modulos.comercial.ordenesCompra.mappers.OrdenCompraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenesComprasServiceImpl implements OrdenesComprasService {
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private OrdenCompraMapper map;

    public List<OrdenCompraEntity> buscarTodos(){
        return ordenCompraRepository.findAll();
    }

    public OrdenCompraEntity buscarPorId(Long ordenCompraId) {
        return ordenCompraRepository
                .findById(ordenCompraId)
                .orElseThrow(() -> new OrdenCompraNotFound("Esta orden de compra no existe"));
    }

    public OrdenCompraEntity crear(CrearOrdenCompraDTO ordenCompra) {
        return ordenCompraRepository.save(map.toEntity(ordenCompra));
    }

    public OrdenCompraEntity actualizar(Long ordenCompraId, ActualizarOrdenCompraDTO datosNuevos) {
        OrdenCompraEntity ordenCompraExistente  = ordenCompraRepository
                .findById(ordenCompraId)
                .orElseThrow(() -> new OrdenCompraNotFound("Esta orden de compra no existe"));

        return ordenCompraRepository.save(map.updateToEntity(datosNuevos, ordenCompraExistente));
    }

    public void eliminar(Long ordenCompraId){
        ordenCompraRepository
                .findById(ordenCompraId)
                .orElseThrow(() -> new OrdenCompraNotFound("Esta orden de compra no existe"));
        ordenCompraRepository.deleteById(ordenCompraId);
    }
}
