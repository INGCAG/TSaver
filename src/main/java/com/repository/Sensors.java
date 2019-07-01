package com.repository;

import com.model.Sensor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called devicesRepository
// CRUD refers Create, Read, Update, Delete
public interface Sensors extends CrudRepository<Sensor, Long> {
    Optional<Sensor> findById(Long deviceId);
}
