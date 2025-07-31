package com.programacion.service;

import com.programacion.model.Persona;
import reactor.core.publisher.Flux;

public interface PersonaService {
    Flux<Persona> obtenerPersonas();
    Flux<Persona> filtrarMayoresDeEdad(Flux<Persona> personas);
    Flux<Persona> filtrarMenoresDeEdad(Flux<Persona> personas);
    Flux<Persona> filtrarAncianos(Flux<Persona> personas);
    Flux<Persona> filtrarPorRangoDeEdad(Flux<Persona> personas, int min, int max);
    Flux<Persona> filtrarPorEdad(Flux<Persona> personas, int edad);
    Flux<Persona> filtrarPorNombre(Flux<Persona> personas, String nombre);
}