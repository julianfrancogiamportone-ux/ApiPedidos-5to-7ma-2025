package com.apipedidos.service.impl;

import com.apipedidos.entity.Restaurante;
import com.apipedidos.repository.RestauranteRepository;
import com.apipedidos.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante getRestauranteById(Long id) {
        return restauranteRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurante saveRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public void deleteRestaurante(Long id) {
        restauranteRepository.deleteById(id);
    }
}
