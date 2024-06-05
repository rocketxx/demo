package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll(); 
    }

    @PostMapping("/create")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PostMapping("/createMock")
    public Restaurant createMock() {
        Restaurant res = new Restaurant();
        res.setAddress("via coppola 53");
        res.setName("Pizze e dolci");
        res.setPhone("4235346436546");
        res.setType("Pizza e Dolci");
        res.setActive(true);
        return restaurantRepository.save(res);
    }

    @PutMapping("/update/{id}")
    public Restaurant updateRestaurant(@PathVariable String id, @RequestBody Restaurant restaurantDetails) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant existingRestaurant = optionalRestaurant.get();
            existingRestaurant.setName(restaurantDetails.getName());
            existingRestaurant.setAddress(restaurantDetails.getAddress());
            existingRestaurant.setPhone(restaurantDetails.getPhone());
            existingRestaurant.setType(restaurantDetails.getType());
            return restaurantRepository.save(existingRestaurant);
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }
    // COLLAUDATA ✅ 
    //endpoint utile se si vuole tagliare fuori un ristorante dalla visualizzazione in home
    @PutMapping("/change-status/{id}")
    public Restaurant activeStatusRestaurant(@PathVariable String id) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant existingRestaurant = optionalRestaurant.get();
            existingRestaurant.setActive(!existingRestaurant.getActive()); //cambia lo stato di attivazione
            return restaurantRepository.save(existingRestaurant);
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable String id) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            restaurantRepository.delete(optionalRestaurant.get());
            return "Restaurant deleted with id " + id;
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }
}
