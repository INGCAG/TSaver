package com.repository;

import com.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called locationsRepository
// CRUD refers Create, Read, Update, Delete
public interface Locations extends CrudRepository<Location, Long> {
    Optional<Location> findById(Long locationId);
}
