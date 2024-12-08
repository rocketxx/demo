package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.OrderItem;

@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, UUID> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
    List<OrderItem> findByUserId(String userId);
}
