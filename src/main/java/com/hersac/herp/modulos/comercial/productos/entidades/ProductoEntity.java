package com.hersac.herp.modulos.comercial.productos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
    private Long categoriaId;
    private Long proveedorId;
}
