package com.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="IOT_DEVICES")// This tells Hibernate to make a table out of this class
@Component
public class Device {

    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_DEVICE", nullable = false)
    private Long deviceId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REFERENCE")
    private String reference;

    public Device(){
        this.reference = "";
    }

    public Device(String reference) {
        this.reference = reference;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }
}
