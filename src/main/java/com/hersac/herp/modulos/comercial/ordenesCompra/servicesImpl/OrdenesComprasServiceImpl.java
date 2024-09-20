package com.hersac.herp.modulos.comercial.ordenesCompra.servicesImpl;

import com.hersac.herp.config.exceptions.comercial.OrdenCompraNotFound;
import com.hersac.herp.config.exceptions.comercial.ProveedorNotFoundException;
import com.hersac.herp.modulos.comercial.ordenesCompra.OrdenesComprasService;
import com.hersac.herp.modulos.comercial.ordenesCompra.dto.ActualizarOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.dto.CrearOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.repositorios.OrdenCompraRepository;
import com.hersac.herp.modulos.comercial.ordenesCompra.mappers.OrdenCompraMapper;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;
import com.hersac.herp.modulos.comercial.proveedores.entidades.repositorios.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenesComprasServiceImpl implements OrdenesComprasService {
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

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
        ProveedorEntity proveedor = proveedorRepository.findById(ordenCompra.getProveedor())
                .orElseThrow(() -> new ProveedorNotFoundException("Este proveedor no existe"));

        OrdenCompraEntity ordenCompraNueva = map.toEntity(ordenCompra);
        ordenCompraNueva.setProveedorId(proveedor);
        return ordenCompraRepository.save(ordenCompraNueva);
    }

    public OrdenCompraEntity actualizar(Long ordenCompraId, ActualizarOrdenCompraDTO datosNuevos) {
        ProveedorEntity proveedor = proveedorRepository.findById(datosNuevos.getProveedor())
                .orElseThrow(() -> new ProveedorNotFoundException("Este proveedor no existe"));

        OrdenCompraEntity ordenCompraExistente  = ordenCompraRepository
                .findById(ordenCompraId)
                .orElseThrow(() -> new OrdenCompraNotFound("Esta orden de compra no existe"));

        ordenCompraExistente.setProveedorId(proveedor);

        return ordenCompraRepository.save(map.updateToEntity(datosNuevos, ordenCompraExistente));
    }

    public void eliminar(Long ordenCompraId){
        ordenCompraRepository
                .findById(ordenCompraId)
                .orElseThrow(() -> new OrdenCompraNotFound("Esta orden de compra no existe"));
        ordenCompraRepository.deleteById(ordenCompraId);
    }
}
