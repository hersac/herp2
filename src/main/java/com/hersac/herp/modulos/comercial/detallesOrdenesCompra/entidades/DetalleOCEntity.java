package com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades;

import com.hersac.herp.modulos.comercial.ordenesCompra.entidades.OrdenCompraEntity;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "detalles_oc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOCEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_oc_id")
    private Long detalleOCId;

    private Integer cantidad;
    private Double precio;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "orden_compra_id")
    private OrdenCompraEntity ordenCompraId;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity productoId;
}
