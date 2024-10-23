package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends MongoRepository<Product, UUID> {
    Product findByCode(String code);
}
