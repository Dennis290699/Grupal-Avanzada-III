package com.programacion;

import com.programacion.model.Producto;
import com.programacion.service.ProductoService;
import com.programacion.service.impl.ProductoServiceImpl;
import com.programacion.util.LoggerFluxSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class App {

    public static void main(String[] args) {
        ProductoService servicio = new ProductoServiceImpl();

        Flux<Producto> flujoTodos = servicio.obtenerProductos();
        LoggerFluxSubscriber.suscribirse(flujoTodos, "Todos los productos");

        Flux<Producto> flujoFiltrado = servicio.obtenerProductosConPrecioMayorA(100.0);
        LoggerFluxSubscriber.suscribirse(flujoFiltrado, "Productos con precio > 100");

        Flux<String> flujoNombres = servicio.obtenerNombresDeProductos();
        LoggerFluxSubscriber.suscribirse(flujoNombres, "Nombres de productos");

        Flux<Producto> flujoOrdenado = servicio.obtenerProductosOrdenadosPorPrecio();
        LoggerFluxSubscriber.suscribirse(flujoOrdenado, "Productos ordenados por precio");

        Mono<Producto> productoMasCaro = servicio.obtenerProductoMasCaro();
        LoggerFluxSubscriber.suscribirseMono(productoMasCaro, "Producto mas caro");
    }
}
