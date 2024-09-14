package com.hersac.herp.modulos.comercial.proveedores.entidades;

import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "proveedores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proveedorId;

    private String nombre;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "proveedorId")
    private List<ProductoEntity> productos;

    @OneToMany(mappedBy = "proveedorId")
    private List<OrdenCompraEntity> ordenesCompra;
}
