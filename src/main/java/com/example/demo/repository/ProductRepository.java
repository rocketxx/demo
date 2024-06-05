package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.product;

public interface ProductRepository extends MongoRepository<product, String> {
    product findByCode(String code);
}
