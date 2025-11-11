package com.apipedidos.service;

import com.apipedidos.entity.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoIService {
    List<Producto> getAllProductos();
    Optional<Producto> getProductoById(Long id);
    Producto createProducto(Producto producto);
    Producto updateProducto(Long id, Producto productoDetails);
    void deleteProducto(Long id);
}
