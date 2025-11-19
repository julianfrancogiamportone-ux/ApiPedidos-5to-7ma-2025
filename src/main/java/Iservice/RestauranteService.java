package com.apipedidos.service;

import com.apipedidos.entity.Restaurante;
import java.util.List;

public interface RestauranteService {

    List<Restaurante> getAllRestaurantes();

    Restaurante getRestauranteById(Long id);

    Restaurante saveRestaurante(Restaurante restaurante);

    void deleteRestaurante(Long id);
}