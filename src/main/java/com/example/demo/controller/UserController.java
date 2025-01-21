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

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired UserRepository userRepository;

     @GetMapping("/all")
    public List<User> all() {
        return userRepository.findAll(); 
    }

    @PostMapping("/upsert")
    public ResponseEntity<User> upsert(@RequestBody User entity) {
        if(entity.getCreatedAt() == null) 
            entity.setCreatedAt(Instant.now());
        return new ResponseEntity<>(userRepository.save(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id)
    {
        userRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}