package com.hersac.herp.modulos.comercial.productos.entidades;

import com.hersac.herp.modulos.comercial.categorias.entidades.CategoriaEntity;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;

    private String nombre;
    private String descripcion;
    private Double precioUnitario;
    private Integer cantidadDisponible;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoriaId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proveedor_id")
    private ProveedorEntity proveedorId;

    @OneToMany(mappedBy = "productoId")
    private List<DetalleOCEntity> detalles;
}
