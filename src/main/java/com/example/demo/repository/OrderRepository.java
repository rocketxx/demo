package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
}
