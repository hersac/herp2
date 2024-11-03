package com.hersac.herp.modulos.pos.detallesVentas.servicesImpl;

import com.hersac.herp.config.exceptions.comercial.ProductoNotFoundException;
import com.hersac.herp.config.exceptions.pos.DetalleVentaNotFoundException;
import com.hersac.herp.config.exceptions.pos.VentaNotFoundException;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import com.hersac.herp.modulos.comercial.productos.entidades.repositorios.ProductoRepository;
import com.hersac.herp.modulos.pos.detallesVentas.DetallesVentasServices;
import com.hersac.herp.modulos.pos.detallesVentas.dto.ActualizarDetalleVentaDTO;
import com.hersac.herp.modulos.pos.detallesVentas.dto.CrearDetalleVentaDTO;
import com.hersac.herp.modulos.pos.detallesVentas.entities.DetalleVentaEntity;
import com.hersac.herp.modulos.pos.detallesVentas.entities.repositories.DetalleVentaRepository;
import com.hersac.herp.modulos.pos.detallesVentas.mappers.DetalleVentaMapper;
import com.hersac.herp.modulos.pos.ventas.entities.VentaEntity;
import com.hersac.herp.modulos.pos.ventas.entities.repoitories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallesVentasServicesImpl implements DetallesVentasServices {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private DetalleVentaMapper detalleVentaMapper;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<DetalleVentaEntity> buscarTodos() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVentaEntity buscarPorId(Long detalleVentaId) {
        return detalleVentaRepository
                .findById(detalleVentaId)
                .orElseThrow(() -> new DetalleVentaNotFoundException("No se encontró el detalle de venta"));
    }

    @Override
    public DetalleVentaEntity crear(CrearDetalleVentaDTO dto) {
        VentaEntity venta = ventaRepository.findById(dto.getVenta())
                .orElseThrow(() -> new VentaNotFoundException("No se encontró la venta"));
        ProductoEntity producto = productoRepository.findById(dto.getProducto())
                .orElseThrow(() -> new ProductoNotFoundException("No se encontró el producto"));
        DetalleVentaEntity detalleVenta = detalleVentaMapper.toEntity(dto);
        detalleVenta.setVentaId(venta);
        detalleVenta.setProductoId(producto);

        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVentaEntity actualizar(Long detalleVentaId, ActualizarDetalleVentaDTO datosNuevos) {

        VentaEntity venta = ventaRepository.findById(datosNuevos.getVenta())
                .orElseThrow(() -> new VentaNotFoundException("No se encontró la venta"));
        ProductoEntity producto = productoRepository.findById(datosNuevos.getProducto())
                .orElseThrow(() -> new ProductoNotFoundException("No se encontró el producto"));
        DetalleVentaEntity detalleVentaExistente = detalleVentaRepository.findById(detalleVentaId)
                .orElseThrow(() -> new DetalleVentaNotFoundException("No se encontró el detalle de venta"));
        DetalleVentaEntity detalleVentaActualizado = detalleVentaMapper.updateToEntity(datosNuevos, detalleVentaExistente);
        detalleVentaActualizado.setVentaId(venta);
        detalleVentaActualizado.setProductoId(producto);

        return detalleVentaRepository.save(detalleVentaActualizado);
    }

    @Override
    public void eliminar(Long detalleVentaId) {
        detalleVentaRepository.findById(detalleVentaId)
                .orElseThrow(() -> new DetalleVentaNotFoundException("No se encontró el detalle de venta"));
        detalleVentaRepository.deleteById(detalleVentaId);
    }

}
