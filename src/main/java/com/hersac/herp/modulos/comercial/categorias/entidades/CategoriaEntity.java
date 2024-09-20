package com.hersac.herp.modulos.comercial.categorias.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hersac.herp.modulos.comercial.productos.entidades.ProductoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categoriaId")
    @JsonIgnore
    private List<ProductoEntity> productos;
}
