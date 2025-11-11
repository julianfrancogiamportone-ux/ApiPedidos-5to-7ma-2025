package com.apipedidos.service;

import com.apipedidos.entity.Restaurante;
import com.apipedidos.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService implements RestauranteIService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Override
    public Optional<Restaurante> getRestauranteById(Long id) {
        return restauranteRepository.findById(id);
    }

    @Override
    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante updateRestaurante(Long id, Restaurante restauranteDetails) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
        restaurante.setNombre(restauranteDetails.getNombre());
        restaurante.setDireccion(restauranteDetails.getDireccion());
        restaurante.setCategoria(restauranteDetails.getCategoria());
        return restauranteRepository.save(restaurante);
    }

    @Override
    public void deleteRestaurante(Long id) {
        restauranteRepository.deleteById(id);
    }
}
