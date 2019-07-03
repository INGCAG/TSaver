package com.controller;

import com.model.Sensor;
import com.repository.Sensors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/sensor")
public class CtrlSensor {

    @Autowired // This means to get the bean called devicesRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private Sensors sensorsRepository;

    @RequestMapping(path="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sensor> getSensor(@PathVariable("id") long id){
        System.out.println("Fetching Sensor with id " + id);
        Sensor se = new Sensor(id, 25.5);
        Optional<Sensor> s = Optional.of(se);//sensorsRepository.findById(id);
        if (s.get() == null) {
            System.out.println("Sensor with id " + id + " not found");
            return new ResponseEntity<Sensor>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Sensor>(s.get(), HttpStatus.OK);
    }
}