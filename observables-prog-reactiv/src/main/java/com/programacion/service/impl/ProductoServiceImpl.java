package com.programacion.service.impl;

import com.programacion.model.Producto;
import com.programacion.service.ProductoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

public class ProductoServiceImpl implements ProductoService {

    private final List<Producto> productos = List.of(
            new Producto("Teclado", 25.99),
            new Producto("Mouse", 15.49),
            new Producto("Monitor", 200.00),
            new Producto("Laptop", 899.99),
            new Producto("Webcam", 49.99),
            new Producto("Impresora", 120.00),
            new Producto("Tablet", 299.50),
            new Producto("Altavoces", 70.00),
            new Producto("Silla ergonomica", 150.00),
            new Producto("Router WiFi", 80.75),
            new Producto("Disco SSD", 99.99),
            new Producto("Tarjeta grafica", 399.95),
            new Producto("Memoria RAM", 89.90),
            new Producto("Cámara DSLR", 750.00),
            new Producto("Microfono", 65.30)
    );

    @Override
    public Flux<Producto> obtenerProductos() {
        return Flux.fromIterable(productos);
    }

    @Override
    public Flux<Producto> obtenerProductosConPrecioMayorA(double minimo) {
        return Flux.fromIterable(productos)
                .filter(p -> p.getPrecio() > minimo);
    }

    @Override
    public Flux<String> obtenerNombresDeProductos() {
        return Flux.fromIterable(productos)
                .map(Producto::getNombre);
    }

    @Override
    public Flux<Producto> obtenerProductosOrdenadosPorPrecio() {
        return Flux.fromStream(
                productos.stream()
                        .sorted(Comparator.comparingDouble(Producto::getPrecio))
        );
    }

    @Override
    public Mono<Producto> obtenerProductoMasCaro() {
        return Flux.fromIterable(productos)
                .sort((a, b) -> Double.compare(b.getPrecio(), a.getPrecio()))
                .next(); // toma solo el primero del Flux
    }

    @Override
    public Flux<Producto> simularRetrasoEnProductos() {
        return Flux.fromIterable(productos)
                .delayElements(Duration.ofSeconds(1)); // simula emisión por segundo
    }
}
