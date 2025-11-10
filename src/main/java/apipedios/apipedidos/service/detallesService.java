package com.apipedidos.service.impl;

import com.apipedidos.entity.DetallePedido;
import com.apipedidos.entity.Pedido;
import com.apipedidos.entity.Producto;
import com.apipedidos.repository.DetallePedidoRepository;
import com.apipedidos.repository.PedidoRepository;
import com.apipedidos.repository.ProductoRepository;
import com.apipedidos.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detalleRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<DetallePedido> getAllDetalles() {
        return detalleRepository.findAll();
    }

    @Override
    public Optional<DetallePedido> getDetalleById(Long id) {
        return detalleRepository.findById(id);
    }

    @Override
    public DetallePedido createDetalle(DetallePedido detallePedido) {
        // validar pedido y producto
        if (detallePedido.getPedido() == null || detallePedido.getPedido().getPedidoId() == null) {
            throw new RuntimeException("El detalle debe tener un pedido válido.");
        }
        Pedido p = pedidoRepository.findById(detallePedido.getPedido().getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id " + detallePedido.getPedido().getPedidoId()));

        if (detallePedido.getProducto() == null || detallePedido.getProducto().getProductoId() == null) {
            throw new RuntimeException("El detalle debe tener un producto válido.");
        }
        Producto prod = productoRepository.findById(detallePedido.getProducto().getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + detallePedido.getProducto().getProductoId()));

        if (detallePedido.getCantidad() <= 0) {
            throw new RuntimeException("La cantidad debe ser mayor que 0.");
        }

        // opcional: actualizar total del pedido fuera de este método (o hacerlo aquí)
        return detalleRepository.save(detallePedido);
    }

    @Override
    public DetallePedido updateDetalle(Long id, DetallePedido detallePedidoDetails) {
        DetallePedido detalle = detalleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado con id " + id));

        if (detallePedidoDetails.getCantidad() > 0) {
            detalle.setCantidad(detallePedidoDetails.getCantidad());
        }

        // permitir cambiar producto/pedido si vienen completos
        if (detallePedidoDetails.getProducto() != null && detallePedidoDetails.getProducto().getProductoId() != null) {
            Producto prod = productoRepository.findById(detallePedidoDetails.getProducto().getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + detallePedidoDetails.getProducto().getProductoId()));
            detalle.setProducto(prod);
        }

        if (detallePedidoDetails.getPedido() != null && detallePedidoDetails.getPedido().getPedidoId() != null) {
            Pedido p = pedidoRepository.findById(detallePedidoDetails.getPedido().getPedidoId())
                    .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id " + detallePedidoDetails.getPedido().getPedidoId()));
            detalle.setPedido(p);
        }

        return detalleRepository.save(detalle);
    }

    @Override
    public void deleteDetalle(Long id) {
        detalleRepository.deleteById(id);
    }
}