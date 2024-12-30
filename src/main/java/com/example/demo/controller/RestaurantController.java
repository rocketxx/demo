package com.example.demo.controller;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> all() {
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> byId(@PathVariable String id) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            return new ResponseEntity<>(optionalRestaurant.get(), HttpStatus.OK);
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }

    @PostMapping("/upsert")
    public ResponseEntity<Restaurant> upsert(@RequestBody Restaurant entity) {
        if(entity.getCreatedAt() == null)
            entity.setCreatedAt(Instant.now());
        return new ResponseEntity<>(restaurantRepository.save(entity), HttpStatus.OK);
    }

    // COLLAUDATA ✅ 
    //endpoint utile se si vuole tagliare fuori un ristorante dalla visualizzazione in home
    @PutMapping("/change-status/{id}")
    public ResponseEntity<Restaurant> activeStatusRestaurant(@PathVariable String id) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant existingRestaurant = optionalRestaurant.get();
                       existingRestaurant.setEnabled(!existingRestaurant.isEnabled()); //cambia lo stato di attivazione
            return new ResponseEntity<>(restaurantRepository.save(existingRestaurant), HttpStatus.OK);
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }

    @PutMapping("/opened/{id}")
    public ResponseEntity<Restaurant> openedRestaurant(@PathVariable String id) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant existingRestaurant = optionalRestaurant.get();
                       existingRestaurant.setOpened(!existingRestaurant.isOpened()); //cambia lo stato di attivazione
            return new ResponseEntity<>(restaurantRepository.save(existingRestaurant), HttpStatus.OK);
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws Exception {
        restaurantRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);

        // Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        // if (optionalRestaurant.isPresent()) {
        //     restaurantRepository.delete(optionalRestaurant.get());
        //     return new ResponseEntity<>("Restaurant deleted with id " + id, HttpStatus.OK);
        // } else {
        //     // Handle the case where the restaurant is not found
        //     // This can be customized based on your application's requirements
        //     throw new Exception("Restaurant not found with id " + id);
        // }
    }
}
