package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
}
