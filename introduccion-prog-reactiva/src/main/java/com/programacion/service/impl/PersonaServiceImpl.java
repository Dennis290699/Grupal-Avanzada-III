package com.programacion.service.impl;

import com.programacion.model.Persona;
import com.programacion.service.PersonaService;
import reactor.core.publisher.Flux;

import java.util.List;

public class PersonaServiceImpl implements PersonaService {

    private final List<Persona> personas = List.of(
            new Persona("Marielena", 21),
            new Persona("Byron", 18),
            new Persona("Dennis", 26),
            new Persona("Angelo", 15),
            new Persona("Sergio", 17),
            new Persona("Cecilia", 12),
            new Persona("Sofia", 30),
            new Persona("Natalia", 65),
            new Persona("Javier", 85)
    );

    @Override
    public Flux<Persona> obtenerPersonas() {
        return Flux.fromIterable(personas);
    }

    @Override
    public Flux<Persona> filtrarMayoresDeEdad(Flux<Persona> personas) {
        return personas.filter(p -> p.edad() >= 18);
    }

    public Flux<Persona> filtrarMenoresDeEdad(Flux<Persona> personas) {
        return personas.filter(p -> p.edad() < 18);
    }

    public Flux<Persona> filtrarAncianos(Flux<Persona> personas) {
        return personas.filter(p -> p.edad() >= 65);
    }

    public Flux<Persona> filtrarPorRangoDeEdad(Flux<Persona> personas, int min, int max) {
        return personas.filter(p -> p.edad() >= min && p.edad() <= max);
    }

    public Flux<Persona> filtrarPorEdad(Flux<Persona> personas, int edad) {
        return personas.filter(p -> p.edad() == edad);
    }

    public Flux<Persona> filtrarPorNombre(Flux<Persona> personas, String nombre) {
        return personas.filter(p -> p.nombre().equals(nombre));
    }
}
