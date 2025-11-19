package com.apipedidos.service.impl;

import com.apipedidos.entity.Repartidor;
import com.apipedidos.repository.RepartidorRepository;
import com.apipedidos.service.RepartidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepartidorServiceImpl implements RepartidorService {

    @Autowired
    private RepartidorRepository repartidorRepository;

    @Override
    public List<Repartidor> getAllRepartidores() {
        return repartidorRepository.findAll();
    }

    @Override
    public Repartidor getRepartidorById(Long id) {
        return repartidorRepository.findById(id).orElse(null);
    }

    @Override
    public Repartidor saveRepartidor(Repartidor repartidor) {
        return repartidorRepository.save(repartidor);
    }

    @Override
    public void deleteRepartidor(Long id) {
        repartidorRepository.deleteById(id);
    }
}
