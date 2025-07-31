package com.programacion.util;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class LoggerFluxSubscriber<T> extends BaseSubscriber<T> {

    private final String titulo;

    public LoggerFluxSubscriber(String titulo) {
        this.titulo = titulo;
    }

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("\n--- " + titulo + " ---");
        request(Long.MAX_VALUE);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println("Elemento recibido: " + value);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("✅ Flujo completado.");
    }
}
