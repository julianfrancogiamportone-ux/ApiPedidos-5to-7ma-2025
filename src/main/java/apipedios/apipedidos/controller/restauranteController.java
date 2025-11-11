package com.apipedidos.controller;

import com.apipedidos.entity.Restaurante;
import com.apipedidos.service.RestauranteIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteIService restauranteService;

    @GetMapping
    public List<Restaurante> getAllRestaurantes() {
        return restauranteService.getAllRestaurantes();
    }

    @GetMapping("/{id}")
    public Optional<Restaurante> getRestauranteById(@PathVariable Long id) {
        return restauranteService.getRestauranteById(id);
    }

    @PostMapping
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteService.createRestaurante(restaurante);
    }

    @PutMapping("/{id}")
    public Restaurante updateRestaurante(@PathVariable Long id, @RequestBody Restaurante restauranteDetails) {
        return restauranteService.updateRestaurante(id, restauranteDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurante(@PathVariable Long id) {
        restauranteService.deleteRestaurante(id);
        return "Restaurante con ID " + id + " eliminado correctamente.";
    }
}
