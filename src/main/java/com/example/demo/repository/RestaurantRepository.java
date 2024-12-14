package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
}
