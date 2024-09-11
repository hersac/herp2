package com.hersac.herp.modulos.comercial.ordenesCompra.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "ordenes_compra")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordenCompraId;

    private Date fecha;
    private Boolean estaActiva;
    private Integer total;
    private Long proveedorId;
}
