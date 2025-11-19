package com.apipedidos.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restauranteId;

    private String nombre;

    private String direccion;

    private String categoria;

    @OneToMany(mappedBy = "restaurante")
    private List<Producto> productos;

    @OneToMany(mappedBy = "restaurante")
    private List<Pedido> pedidos;

    public Restaurante() {}

    public Restaurante(String nombre, String direccion, String categoria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoria = categoria;
    }

    public Long getRestauranteId() { return restauranteId; }
    public void setRestauranteId(Long restauranteId) { this.restauranteId = restauranteId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
