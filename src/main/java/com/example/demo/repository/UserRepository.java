package com.example.demo.repository;


import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
}
