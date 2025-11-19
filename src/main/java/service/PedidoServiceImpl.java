package com.apipedidos.service.impl;

import com.apipedidos.entity.Pedido;
import com.apipedidos.repository.PedidoRepository;
import com.apipedidos.service.PedidoService;
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
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido updatePedido(Long id, Pedido pedidoDetails) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();

            pedido.setFechaPedido(pedidoDetails.getFechaPedido());
            pedido.setTotal(pedidoDetails.getTotal());
            pedido.setUsuario(pedidoDetails.getUsuario());
            pedido.setRestaurante(pedidoDetails.getRestaurante());
            pedido.setRepartidor(pedidoDetails.getRepartidor());

            return pedidoRepository.save(pedido);
        }

        return null;
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
