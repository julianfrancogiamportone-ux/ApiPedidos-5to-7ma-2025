package com.apipedidos.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Repartidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repartidorId;

    private String nombre;
    private String vehiculo;
    private String telefono;

    @OneToMany(mappedBy = "repartidor")
    private List<Pedido> pedidos;

    public Repartidor() {}

    public Repartidor(String nombre, String vehiculo, String telefono) {
        this.nombre = nombre;
        this.vehiculo = vehiculo;
        this.telefono = telefono;
    }

    public Long getRepartidorId() { return repartidorId; }
    public void setRepartidorId(Long repartidorId) { this.repartidorId = repartidorId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getVehiculo() { return vehiculo; }
    public void setVehiculo(String vehiculo) { this.vehiculo = vehiculo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
