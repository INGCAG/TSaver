package com.repository;

import com.model.Metric;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called metricsRepository
// CRUD refers Create, Read, Update, Delete
public interface Metrics extends CrudRepository<Metric, Long> {
    Optional<Metric> findById(Long deviceId);
}
