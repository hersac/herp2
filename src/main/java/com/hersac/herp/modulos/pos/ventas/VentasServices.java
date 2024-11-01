package com.hersac.herp.modulos.pos.ventas;

import com.hersac.herp.modulos.pos.ventas.dto.ActualizarVentaDTO;
import com.hersac.herp.modulos.pos.ventas.dto.CrearVentaDTO;
import com.hersac.herp.modulos.pos.ventas.entities.VentaEntity;

import java.util.List;

public interface VentasServices {
    public List<VentaEntity> buscarTodos();
    public VentaEntity buscarPorId(Long ventaId);
    public VentaEntity crear(CrearVentaDTO dto);
    public VentaEntity actualizar(Long ventaId, ActualizarVentaDTO datosNuevos);
    public void eliminar(Long ventaId);
}
