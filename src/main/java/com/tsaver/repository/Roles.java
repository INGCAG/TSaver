package com.tsaver.repository;

import com.tsaver.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface Roles extends CrudRepository<Role, Long> {
    Optional<Role> findById(Long roleId);
}
