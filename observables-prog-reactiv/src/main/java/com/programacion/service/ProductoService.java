package com.programacion.service;

import com.programacion.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {
    Flux<Producto> obtenerProductos();

    Flux<Producto> obtenerProductosConPrecioMayorA(double minimo);

    Flux<String> obtenerNombresDeProductos();

    Flux<Producto> obtenerProductosOrdenadosPorPrecio();

    Mono<Producto> obtenerProductoMasCaro();

    Flux<Producto> simularRetrasoEnProductos();
}

