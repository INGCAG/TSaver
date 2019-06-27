package com.repository;

import com.model.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called devicesRepository
// CRUD refers Create, Read, Update, Delete
public interface Devices extends CrudRepository<Device, Long> {
    Optional<Device> findById(Long deviceId);
}
