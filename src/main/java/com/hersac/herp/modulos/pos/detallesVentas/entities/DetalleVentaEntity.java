package com.hersac.herp.modulos.pos.detallesVentas.entities;

import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import com.hersac.herp.modulos.pos.ventas.entities.VentaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "detalles_ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleVentaId;

    private Integer cantidad;
    private Double precioUnitario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private VentaEntity ventaId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private ProductoEntity productoId;
}
