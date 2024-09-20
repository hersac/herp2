package com.hersac.herp.modulos.comercial.productos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // Relaciones
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoriaId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proveedor_id")
    private ProveedorEntity proveedorId;

    // Relaciones externas
    @OneToMany(mappedBy = "productoId")
    @JsonIgnore
    private List<DetalleOCEntity> detalles;
}
