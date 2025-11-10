package com.apipedidos.controller;

import com.apipedidos.entity.DetallePedido;
import com.apipedidos.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalles")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> getAllDetalles() {
        return detallePedidoService.getAllDetalles();
    }

    @GetMapping("/{id}")
    public Optional<DetallePedido> getDetalleById(@PathVariable Long id) {
        return detallePedidoService.getDetalleById(id);
    }

    @PostMapping
    public DetallePedido createDetalle(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.createDetalle(detallePedido);
    }

    @PutMapping("/{id}")
    public DetallePedido updateDetalle(@PathVariable Long id, @RequestBody DetallePedido detallePedidoDetails) {
        return detallePedidoService.updateDetalle(id, detallePedidoDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteDetalle(@PathVariable Long id) {
        detallePedidoService.deleteDetalle(id);
        return "Detalle de pedido con ID " + id + " eliminado correctamente.";
    }
}

