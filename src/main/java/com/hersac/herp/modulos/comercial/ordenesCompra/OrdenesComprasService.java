package com.hersac.herp.modulos.comercial.ordenesCompra;

import com.hersac.herp.modulos.comercial.ordenesCompra.dto.ActualizarOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.dto.CrearOrdenCompraDTO;
import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;

import java.util.List;

public interface OrdenesComprasService {
    public List<OrdenCompraEntity> buscarTodos();
    public OrdenCompraEntity buscarPorId(Long ordenCompraId);
    public OrdenCompraEntity crear(CrearOrdenCompraDTO ordenCompra);
    public OrdenCompraEntity actualizar(Long ordenCompraId, ActualizarOrdenCompraDTO datosNuevos);
    public void eliminar(Long ordenCompraId);
}
