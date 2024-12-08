package com.example.demo.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.MenuItem;

public interface MenuItemRepository extends MongoRepository<MenuItem, UUID> {
    List<MenuItem> findByRestaurantId(String restaurantId);
}

