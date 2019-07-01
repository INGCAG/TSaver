package com.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Component
public class Sensor {

    private Long sensorId;

    private Double temperature;

    public Sensor(){

        this.sensorId = 1L;
        this.temperature = 25.0;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public Double getTemperature() {
        return temperature;
    }
}
