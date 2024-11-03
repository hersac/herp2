package com.hersac.herp.modulos.pos.detallesVentas;

import com.hersac.herp.modulos.pos.detallesVentas.dto.ActualizarDetalleVentaDTO;
import com.hersac.herp.modulos.pos.detallesVentas.dto.CrearDetalleVentaDTO;
import com.hersac.herp.modulos.pos.detallesVentas.entities.DetalleVentaEntity;

import java.util.List;

public interface DetallesVentasServices {
    public List<DetalleVentaEntity> buscarTodos();
    public DetalleVentaEntity buscarPorId(Long detalleVentaId);
    public DetalleVentaEntity crear(CrearDetalleVentaDTO dto);
    public DetalleVentaEntity actualizar(Long detalleVentaId, ActualizarDetalleVentaDTO datosNuevos);
    public void eliminar(Long detalleVentaId);
}
