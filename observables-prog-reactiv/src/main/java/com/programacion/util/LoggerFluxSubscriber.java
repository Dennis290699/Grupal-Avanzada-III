package com.programacion.util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class LoggerFluxSubscriber {
    public static <T> void suscribirse(Flux<T> flujo, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        flujo.subscribe(
                crearConsumer(),
                crearErrorHandler(),
                crearCompletadoHandler()
        );
    }

    public static <T> void suscribirseMono(Mono<T> mono, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        mono.subscribe(
                crearConsumer(),
                crearErrorHandler(),
                crearCompletadoHandler()
        );
    }

    private static <T> Consumer<T> crearConsumer() {
        return item -> System.out.println("Elemento recibido: " + item);
    }

    private static Consumer<Throwable> crearErrorHandler() {
        return error -> System.err.println("❌ Error en flujo: " + error.getMessage());
    }

    private static Runnable crearCompletadoHandler() {
        return () -> System.out.println("✔️ Flujo completado.");
    }
}
