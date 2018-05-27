package com.tsaver.repository;

import com.tsaver.model.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Tweets extends CrudRepository<Tweet, Long> {
        Optional<Tweet> findById(Long userId);
}
