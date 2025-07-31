package com.programacion.service;

import com.programacion.model.SensorData;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class SensorService {

    public Flux<SensorData> flujoSensores() {
        List<SensorData> datos = List.of(
                new SensorData("A1", 75),
                new SensorData("A1", 75),
                new SensorData("A1", 80),
                new SensorData("A1", 95),
                new SensorData("A1", 110),
                new SensorData("A1", 102),
                new SensorData("A1", 90),
                new SensorData("A1", 65)
        );

        return Flux.fromIterable(datos)
                .delayElements(Duration.ofMillis(200));
    }
}
