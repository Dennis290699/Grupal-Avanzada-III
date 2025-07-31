package com.programacion;

import com.programacion.service.SensorService;
import com.programacion.util.LoggerFluxSubscriber;
import com.programacion.model.SensorData;
import reactor.core.publisher.Flux;

public class App {

    public static void main(String[] args) throws InterruptedException {
        SensorService service = new SensorService();

        Flux<SensorData> flujoProcesado = service.flujoSensores()
                .filter(data -> data.getTemperatura() >= 70 && data.getTemperatura() <= 100)
                .distinctUntilChanged(data -> data.getTemperatura())
                .map(SensorData::toCelsius)
                .take(5);

        flujoProcesado.subscribe(new LoggerFluxSubscriber<>("Lecturas de Sensor Procesadas"));

        Thread.sleep(3000); // solo para permitir que el flujo termine en este ejemplo
    }
}
