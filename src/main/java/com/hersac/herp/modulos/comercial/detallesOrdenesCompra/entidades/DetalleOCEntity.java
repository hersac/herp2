package com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades;

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

    private Long ordenCompraId;
    private Long productoId;
    private Integer cantidad;
    private Double precio;
}
