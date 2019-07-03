package com.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="IOT_METRICS")// This tells Hibernate to make a table out of this class
@Component
public class Metric {

    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_METRIC", nullable = false)
    private Long metricId;

    @Column(name = "TEMPERATURE")
    private Double temperature;

    @Column(name = "HUMIDITY")
    private Double humidity;

    @Column(name = "WIND_SPEED")
    private Double windSpeed;

    @Column(name = "TIME")
    private Date dateTime;

    @Column(name = "ICON")
    private String icon;

    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "ID_DEVICE")
    private Long deviceId;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "SENSOR_TEMPERTAURE")
    private Double sensorTemperature;

    public Metric(){
    }

    public Metric(Long metricId) {
        this.metricId = metricId;
    }

    public Metric(Long metricId, Double temperature, Double humidity, Double windSpeed, Date dateTime, String icon, Long userId, Long deviceId, Double latitude, Double longitude, Double sensorTemperature) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.metricId = metricId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.dateTime = dateTime;
        this.icon = icon;
        this.userId = userId;
        this.deviceId = deviceId;
        this.sensorTemperature = sensorTemperature;
    }

    public Long getMetricId() {
        return metricId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getIcon() {
        return icon;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getSensorTemperature() {
        return sensorTemperature;
    }

}
