package com.programacion.model;

public class SensorData {
    private final String sensorId;
    private final double temperatura;

    public SensorData(String sensorId, double temperatura) {
        this.sensorId = sensorId;
        this.temperatura = temperatura;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public SensorData toCelsius() {
        double celsius = (temperatura - 32) * 5.0 / 9.0;
        return new SensorData(sensorId, celsius);
    }

    @Override
    public String toString() {
        return "Sensor[" + sensorId + "] -> " + temperatura + " Grados";
    }
}
