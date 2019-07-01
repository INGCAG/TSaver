package com.model;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Component
public class Sensor {

    @Id
    private Long sensorId;

    private Double temperature;

    public Sensor(){}

    public Sensor(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Sensor(Double temperature){ this.temperature = temperature; }

    public Sensor(Long sensorId, Double temperature){
        this.sensorId = sensorId;//1L
        this.temperature = temperature;//25.0;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public Double getTemperature() {
        return temperature;
    }
}
