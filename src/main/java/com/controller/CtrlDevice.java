package com.controller;

import com.model.Device;
import com.repository.Devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/device")
public class CtrlDevice {

    @Autowired // This means to get the bean called devicesRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private Devices deviceRepository;

    @GetMapping(path="/lst")
    public @ResponseBody Iterable<Device> listDevices() {
        // This returns a JSON or XML with the devices
        return deviceRepository.findAll();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> getDevice(@PathVariable("id") long id){
        System.out.println("Fetching Device with id " + id);
        Optional<Device> r = deviceRepository.findById(id);
        if (r.get() == null) {
            System.out.println("Device with id " + id + " not found");
            return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Device>(r.get(), HttpStatus.OK);
    }
}
