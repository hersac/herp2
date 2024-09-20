package com.hersac.herp.modulos.comercial.ordenesCompra.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hersac.herp.modulos.comercial.detallesOrdenesCompra.entidades.DetalleOCEntity;
import com.hersac.herp.modulos.comercial.proveedores.entidades.ProveedorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    private Double total;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private ProveedorEntity proveedorId;

    // Relaciones Externas
    @OneToMany(mappedBy = "ordenCompraId")
    @JsonIgnore
    private List<DetalleOCEntity> detalles;
}
