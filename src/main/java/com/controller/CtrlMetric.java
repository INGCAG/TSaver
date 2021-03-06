package com.controller;

import com.model.Metric;
import com.repository.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping(path = "/metric")
public class CtrlMetric {
    @Autowired // This means to get the bean called metricsRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private Metrics metricsRepository;

    @CrossOrigin(origins = "https://master-seu-iot-rest.herokuapp.com")
    @GetMapping(path="/lst") // Map ONLY GET Requests
    public @ResponseBody
    Iterable<Metric> listMetrics() {
        // This returns a JSON or XML with the metrics
        return metricsRepository.findAll();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countAll() {
        System.out.println("Counting All Metrics ");

        Iterator i = metricsRepository.findAll().iterator();
        Long c = 0L;
        while(i.hasNext()) {
            c++;
            i.next();
        }
        return new ResponseEntity<Long>(c, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Metric> getMetric(@PathVariable("id") long id) {
        System.out.println("Fetching Metric with id " + id);
        Optional<Metric> m = metricsRepository.findById(id);
        if (m.get() == null) {
            System.out.println("Metric with id " + id + " not found");
            return new ResponseEntity<Metric>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Metric>(m.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createMetric(@RequestBody Metric metric, UriComponentsBuilder ucBuilder) {
        System.out.println("Saving Metric " + metric.getMetricId());

        metricsRepository.save(metric);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(metric.getMetricId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Metric> updateMetric(@PathVariable("id") long id, @RequestBody Metric metric) {
        System.out.println("Updating Metric " + id);
        Optional<Metric> m = metricsRepository.findById(id);

        if (m.get()==null) {
            System.out.println("Metric with id " + id + " not found");
            return new ResponseEntity<Metric>(HttpStatus.NOT_FOUND);
        }

        Metric updatedMetric = new Metric(m.get().getMetricId(),metric.getTemperature(),metric.getHumidity(),metric.getWindSpeed(), metric.getDateTime(), metric.getIcon(), metric.getDeviceId(), metric.getUserId(), metric.getLatitude(), metric.getLongitude(), metric.getSensorTemperature());

        metricsRepository. save(updatedMetric);
        return new ResponseEntity<Metric>(updatedMetric, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Metric> deleteMetric(@PathVariable("id") long id) {
        System.out.println("Deleting Metric " + id);
        Optional<Metric> u = metricsRepository.findById(id);

        if (u.get()==null) {
            System.out.println("Metric with id " + id + " not found");
            return new ResponseEntity<Metric>(HttpStatus.NOT_FOUND);
        }

        metricsRepository. delete(u.get());
        return new ResponseEntity<Metric>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteAll() {
        System.out.println("Deleting All Metrics ");

        metricsRepository. deleteAll();
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
