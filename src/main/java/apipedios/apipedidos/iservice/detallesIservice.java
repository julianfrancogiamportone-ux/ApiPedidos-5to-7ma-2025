package com.apipedidos.service;

import com.apipedidos.entity.DetallePedido;
import java.util.List;
import java.util.Optional;

public interface DetallePedidoService {

    List<DetallePedido> getAllDetalles();

    Optional<DetallePedido> getDetalleById(Long id);

    DetallePedido createDetalle(DetallePedido detallePedido);

    DetallePedido updateDetalle(Long id, DetallePedido detallePedidoDetails);

    void deleteDetalle(Long id);
}

