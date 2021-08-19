package com.pia.workshop.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pia.workshop.model.User;

public interface UserRepository extends MongoRepository<User, UUID>{
       List<User> findByName(String name);
       User findByUsername(String username);
}
