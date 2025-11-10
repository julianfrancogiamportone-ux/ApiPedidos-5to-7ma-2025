package com.apipedidos.service;

import com.apipedidos.entity.Restaurante;
import java.util.List;
import java.util.Optional;

public interface RestauranteService {

    List<Restaurante> getAllRestaurantes();

    Optional<Restaurante> getRestauranteById(Long id);

    Restaurante createRestaurante(Restaurante restaurante);

    Restaurante updateRestaurante(Long id, Restaurante restauranteDetails);

    void deleteRestaurante(Long id);
}
