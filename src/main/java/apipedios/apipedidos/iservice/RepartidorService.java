package com.apipedidos.service;

import com.apipedidos.entity.Repartidor;
import java.util.List;

public interface RepartidorService {

    List<Repartidor> getAllRepartidores();

    Repartidor getRepartidorById(Long id);

    Repartidor saveRepartidor(Repartidor repartidor);

    void deleteRepartidor(Long id);
}
