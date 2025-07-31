package com.programacion.util;

import com.programacion.model.Persona;
import reactor.core.publisher.Mono;

public class Formateador {

    public static Mono<String> formatear(Persona persona) {
        return Mono.just(String.format("Nombre: %s, Edad: %d", persona.nombre(), persona.edad()));
    }
}
