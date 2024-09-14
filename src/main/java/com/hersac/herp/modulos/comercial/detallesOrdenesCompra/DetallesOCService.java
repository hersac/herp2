package com.hersac.herp.modulos.comercial.detallesOrdenesCompra;

import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.ActualizarDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.dto.CrearDetalleOCDTO;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;

import java.util.List;

public interface DetallesOCService {
    public List<DetalleOCEntity> buscarTodos();
    public DetalleOCEntity buscarPorId(Long detalleOCId);
    public DetalleOCEntity crear(CrearDetalleOCDTO detalleOC);
    public DetalleOCEntity actualizar(Long detalleOCId, ActualizarDetalleOCDTO datosNuevos);
    public void eliminar(Long detalleOCId);
}
