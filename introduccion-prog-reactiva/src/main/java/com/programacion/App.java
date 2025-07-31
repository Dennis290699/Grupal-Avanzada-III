package com.programacion;

import com.programacion.model.Persona;
import com.programacion.service.PersonaService;
import com.programacion.service.impl.PersonaServiceImpl;
import com.programacion.util.Formateador;
import reactor.core.publisher.Flux;

public class App {
    public static void main(String[] args) {
        PersonaService servicio = new PersonaServiceImpl();

        Flux<Persona> personas = servicio.obtenerPersonas();
        Flux<String> resultados = servicio.filtrarMayoresDeEdad(personas)
                .flatMap(Formateador::formatear);

        Flux<String> resultados1 = servicio.filtrarMenoresDeEdad(personas)
                .flatMap(Formateador::formatear);

        Flux<String> resultados2 = servicio.filtrarAncianos(personas)
                .flatMap(Formateador::formatear);

        Flux<String> resultados3 = servicio.filtrarPorRangoDeEdad(personas, 18, 23)
                .flatMap(Formateador::formatear);

        Flux<String> resultados4 = servicio.filtrarPorEdad(personas, 18)
                .flatMap(Formateador::formatear);

        Flux<String> resultados5 = servicio.filtrarPorNombre(personas, "Marielena")
                .flatMap(Formateador::formatear);

        System.out.println("----MAYORES---------");
        resultados.subscribe(System.out::println);
        System.out.println("----MENORES---------");
        resultados1.subscribe(System.out::println);
        System.out.println("----ANCIANOS---------");
        resultados2.subscribe(System.out::println);
        System.out.println("----RANGO---------");
        resultados3.subscribe(System.out::println);
        System.out.println("----EDAD---------");
        resultados4.subscribe(System.out::println);
        System.out.println("----NOMBRE---------");
        resultados5.subscribe(System.out::println);
    }
}
