package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        res.setAddress("via cappuccini 174");
        res.setName("Ristorante bello");
        res.setPhone("3383831834");
        res.setType("Pizzeria");
        return restaurantRepository.save(res);
    }
}
