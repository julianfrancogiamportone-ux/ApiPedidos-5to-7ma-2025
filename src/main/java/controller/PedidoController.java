package com.apipedidos.controller;

import com.apipedidos.entity.Pedido;
import com.apipedidos.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.createPedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoDetails) {
        return pedidoService.updatePedido(id, pedidoDetails);
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return "Pedido con ID " + id + " eliminado correctamente.";
    }
}
