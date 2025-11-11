package com.apipedidos.repository;

import com.apipedidos.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> { }

RestauranteIService.java

package com.apipedidos.service;

import com.apipedidos.entity.Restaurante;
import java.util.List;
import java.util.Optional;

public interface RestauranteIService {
    List<Restaurante> getAllRestaurantes();
    Optional<Restaurante> getRestauranteById(Long id);
    Restaurante createRestaurante(Restaurante restaurante);
    Restaurante updateRestaurante(Long id, Restaurante restauranteDetails);
    void deleteRestaurante(Long id);
}
