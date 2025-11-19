package com.apipedidos.controller;

import com.apipedidos.entity.Repartidor;
import com.apipedidos.service.RepartidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repartidores")
public class RepartidorController {

    @Autowired
    private RepartidorService repartidorService;

    // GET - obtener todos los repartidores
    @GetMapping
    public List<Repartidor> getAll() {
        return repartidorService.getAllRepartidores();
    }

    // GET - obtener repartidor por ID
    @GetMapping("/{id}")
    public Repartidor getById(@PathVariable Long id) {
        return repartidorService.getRepartidorById(id);
    }

    // POST - crear repartidor
    @PostMapping
    public Repartidor create(@RequestBody Repartidor repartidor) {
        return repartidorService.saveRepartidor(repartidor);
    }

    // PUT - actualizar repartidor
    @PutMapping("/{id}")
    public Repartidor update(@PathVariable Long id, @RequestBody Repartidor repartidor) {
        Repartidor existing = repartidorService.getRepartidorById(id);

        if (existing == null) {
            return null; // opcional: lanzar error
        }

        existing.setNombre(repartidor.getNombre());
        existing.setVehiculo(repartidor.getVehiculo());
        existing.setTelefono(repartidor.getTelefono());

        return repartidorService.saveRepartidor(existing);
    }

    // DELETE - eliminar repartidor
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repartidorService.deleteRepartidor(id);
    }
}
