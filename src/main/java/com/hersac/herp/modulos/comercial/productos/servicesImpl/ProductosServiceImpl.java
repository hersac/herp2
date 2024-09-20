package com.hersac.herp.modulos.comercial.productos.servicesImpl;

import com.hersac.herp.config.exceptions.comercial.CategoriaNotFoundException;
import com.hersac.herp.config.exceptions.comercial.ProductoNotFoundException;
import com.hersac.herp.config.exceptions.comercial.ProveedorNotFoundException;
import com.hersac.herp.modulos.comercial.categorias.entidades.CategoriaEntity;
import com.hersac.herp.modulos.comercial.categorias.entidades.repositorios.CategoriaRepository;
import com.hersac.herp.modulos.comercial.productos.ProductosService;
import com.hersac.herp.modulos.comercial.productos.dto.ActualizarProductoDTO;
import com.hersac.herp.modulos.comercial.productos.dto.CrearProdutoDTO;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import com.hersac.herp.modulos.comercial.productos.entidades.repositorios.ProductoRepository;
import com.hersac.herp.modulos.comercial.productos.mappers.ProductoMapper;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;
import com.hersac.herp.modulos.comercial.proveedores.entidades.repositorios.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {
    @Autowired
    private ProductoRepository productosRepository;

    @Autowired
    private CategoriaRepository categoriasRepository;

    @Autowired
    private ProveedorRepository proveedoresRepository;

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

        CategoriaEntity categoria = categoriasRepository
                .findById(producto.getCategoria())
                .orElseThrow(() -> new CategoriaNotFoundException("Esta categoría no existe"));

        ProveedorEntity proveedor = proveedoresRepository
                .findById(producto.getProveedor())
                .orElseThrow(() -> new ProveedorNotFoundException("Este proveedor no existe"));

        ProductoEntity productoNuevo = map.toEntity(producto);
        productoNuevo.setCategoriaId(categoria);
        productoNuevo.setProveedorId(proveedor);

        return productosRepository.save(productoNuevo);
    }

    @Override
    public ProductoEntity actualizar(Long productoId, ActualizarProductoDTO datosNuevos) {
        CategoriaEntity categoria = categoriasRepository
                .findById(datosNuevos.getCategoria())
                .orElseThrow(() -> new CategoriaNotFoundException("Esta categoría no existe"));

        ProveedorEntity proveedor = proveedoresRepository
                .findById(datosNuevos.getProveedor())
                .orElseThrow(() -> new ProveedorNotFoundException("Este proveedor no existe"));

        ProductoEntity productoExistente = productosRepository
                .findById(productoId)
                .orElseThrow(() -> new ProductoNotFoundException("Este producto no existe"));

        productoExistente.setCategoriaId(categoria);
        productoExistente.setProveedorId(proveedor);


        return productosRepository.save(map.updateToEntity(datosNuevos, productoExistente));
    }

    public void eliminar(Long productoId) {
        productosRepository
                .findById(productoId)
                .orElseThrow(() -> new ProductoNotFoundException("Este producto no existe"));
        productosRepository.deleteById(productoId);
    }
}
