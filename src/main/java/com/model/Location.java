package com.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="IOT_LOCATIONS")// This tells Hibernate to make a table out of this class
@Component
public class Location {

    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_LOCATION", nullable = false)
    private Long locationId;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    public Location(){
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
