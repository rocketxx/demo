package com.example.demo.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    
    @GetMapping("/all")
    public List<Order> all() {
        return orderRepository.findAll(); 
    }

    @PostMapping("/upsert")
    public ResponseEntity<Order> upsert(@RequestBody Order entity) {
        if(entity.getCreatedAt() == null) 
            entity.setCreatedAt(Instant.now());
        return new ResponseEntity<>(orderRepository.save(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id)
    {
        orderRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}