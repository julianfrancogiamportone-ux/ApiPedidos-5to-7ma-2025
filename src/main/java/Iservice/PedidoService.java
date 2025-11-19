package com.apipedidos.service;

import com.apipedidos.entity.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> getAllPedidos();

    Optional<Pedido> getPedidoById(Long id);

    Pedido createPedido(Pedido pedido);

    Pedido updatePedido(Long id, Pedido pedidoDetails);

    void deletePedido(Long id);
}
