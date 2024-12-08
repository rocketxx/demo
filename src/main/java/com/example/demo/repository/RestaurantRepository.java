package com.example.demo.repository;


import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, UUID> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
}
