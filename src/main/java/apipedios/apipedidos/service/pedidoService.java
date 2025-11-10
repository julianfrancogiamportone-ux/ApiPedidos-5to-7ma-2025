package com.apipedidos.service;

import com.apipedidos.entity.Pedido;
import com.apipedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }


    @Override
    public Optional<Pedido> getPedidoById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido createPedido(Pedido pedido) {

        if (pedido.getUsuario() == null) {
            throw new RuntimeException("El pedido debe tener un usuario asignado.");
        }
        return pedidoRepository.save(pedido);
    }


    @Override
    public Pedido updatePedido(Long id, Pedido pedidoDetails) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));

        pedido.setFechaPedido(pedidoDetails.getFechaPedido());
        pedido.setTotal(pedidoDetails.getTotal());
        pedido.setUsuario(pedidoDetails.getUsuario());
        pedido.setRestaurante(pedidoDetails.getRestaurante());
        pedido.setRepartidor(pedidoDetails.getRepartidor());

        return pedidoRepository.save(pedido);
    }


    @Override
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}