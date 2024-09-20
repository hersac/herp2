package com.hersac.herp.modulos.comercial.detallesOrdenesCompra.servicesImpl;

import com.hersac.herp.config.exceptions.comercial.DetalleOCNotFoundException;
import com.hersac.herp.config.exceptions.comercial.OrdenCompraNotFound;
import com.hersac.herp.config.exceptions.comercial.ProductoNotFoundException;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.DetallesOCService;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.ActualizarDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.CrearDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.repositorios.DetalleOCRespository;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.mappers.DetalleOCMappers;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.repositorios.OrdenCompraRepository;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import com.hersac.herp.modulos.comercial.productos.entidades.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallesOCServiceImpl implements DetallesOCService {
    @Autowired
    private DetalleOCRespository detalleOCRepository;

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private ProductoRepository productoRepository;

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

        OrdenCompraEntity ordenCompra = ordenCompraRepository
                .findById(detalleOC.getOrdenCompra())
                .orElseThrow(() -> new OrdenCompraNotFound("La orden de compra no existe"));

        ProductoEntity producto = productoRepository
                .findById(detalleOC.getProducto())
                .orElseThrow(() -> new ProductoNotFoundException("El producto no existe"));

        DetalleOCEntity detalleOCNuevo = map.toEntity(detalleOC);
        detalleOCNuevo.setOrdenCompraId(ordenCompra);
        detalleOCNuevo.setProductoId(producto);
        return detalleOCRepository.save(detalleOCNuevo);
    }

    public DetalleOCEntity actualizar(Long detalleOCId, ActualizarDetalleOCDTO datosNuevos) {
        OrdenCompraEntity ordenCompra = ordenCompraRepository
                .findById(datosNuevos.getOrdenCompra())
                .orElseThrow(() -> new OrdenCompraNotFound("La orden de compra no existe"));

        ProductoEntity producto = productoRepository
                .findById(datosNuevos.getProducto())
                .orElseThrow(() -> new ProductoNotFoundException("El producto no existe"));

        DetalleOCEntity detalleOCExistente  = detalleOCRepository
                .findById(detalleOCId)
                .orElseThrow(() -> new DetalleOCNotFoundException("El detalle de la orden no existe"));

        detalleOCExistente.setOrdenCompraId(ordenCompra);
        detalleOCExistente.setProductoId(producto);

        return detalleOCRepository.save(map.updateToEntity(datosNuevos, detalleOCExistente));
    }

    public void eliminar(Long ordenCompraId){
        detalleOCRepository
                .findById(ordenCompraId)
                .orElseThrow(() -> new DetalleOCNotFoundException("El detalle de la orden no existe"));
        detalleOCRepository.deleteById(ordenCompraId);
    }
}
