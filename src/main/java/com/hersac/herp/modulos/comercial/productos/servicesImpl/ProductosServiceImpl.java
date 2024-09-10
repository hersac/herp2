package com.hersac.herp.modulos.comercial.productos.servicesImpl;

import com.hersac.herp.config.exceptions.ProductoNotFoundException;
import com.hersac.herp.modulos.comercial.productos.ProductosService;
import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import com.hersac.herp.modulos.comercial.productos.entidades.repositorios.ProductoRepository;
import com.hersac.herp.modulos.comercial.productos.mappers.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {
    @Autowired
    private ProductoRepository productosRepository;

    @Autowired
    private ProductoMapper map;

    @Override
    public List<ProductoEntity> buscarTodos() {
        return productosRepository.findAll();
    }

    @Override
    public ProductoEntity buscarPorId(Long productoId) {
        return productosRepository
                .findById(productoId)
                .orElseThrow(() -> new ProductoNotFoundException("Este producto no existe"));
    }

    @Override
    public ProductoEntity crear(CrearProdutoDTO producto) {
        return productosRepository.save(map.toEntity(producto));
    }

    @Override
    public ProductoEntity actualizar(Long productoId, ActualizarProductoDTO datosNuevos) {
        ProductoEntity productoExistente = productosRepository
                .findById(productoId)
                .orElseThrow(() -> new ProductoNotFoundException("Este producto no existe"));

        return productosRepository.save(map.updateToEntity(datosNuevos, productoExistente));
    }

    public void eliminar(Long productoId) {
        productosRepository
                .findById(productoId)
                .orElseThrow(() -> new ProductoNotFoundException("Este producto no existe"));
        productosRepository.deleteById(productoId);
    }
}
