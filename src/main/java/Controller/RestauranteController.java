package com.apipedidos.controller;

import com.apipedidos.entity.Restaurante;
import com.apipedidos.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    // GET - obtener todos los restaurantes
    @GetMapping
    public List<Restaurante> getAll() {
        return restauranteService.getAllRestaurantes();
    }

    // GET - obtener un restaurante por ID
    @GetMapping("/{id}")
    public Restaurante getById(@PathVariable Long id) {
        return restauranteService.getRestauranteById(id);
    }

    // POST - crear un restaurante
    @PostMapping
    public Restaurante create(@RequestBody Restaurante restaurante) {
        return restauranteService.saveRestaurante(restaurante);
    }

    // PUT - actualizar un restaurante
    @PutMapping("/{id}")
    public Restaurante update(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        Restaurante existing = restauranteService.getRestauranteById(id);

        if (existing == null) {
            return null; // o podrías lanzar un error
        }

        existing.setNombre(restaurante.getNombre());
        existing.setDireccion(restaurante.getDireccion());
        existing.setCategoria(restaurante.getCategoria());

        return restauranteService.saveRestaurante(existing);
    }

    // DELETE - eliminar restaurante
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restauranteService.deleteRestaurante(id);
    }
}
