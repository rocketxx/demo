package com.example.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.MenuItem;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
}

