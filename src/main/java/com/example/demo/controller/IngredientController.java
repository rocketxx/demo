package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ingredient;
import com.example.demo.repository.IngredientRepository;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientsRepository;
    @GetMapping("/all")
    public List<Ingredient> getAllIngredientss() {
        return ingredientsRepository.findAll(); 
    }
//PAGINAZIONE
    // @GetMapping("/all")
    // public Page<Ingredient> getAllIngredients(@RequestParam(defaultValue = "0") int page,
    //                                           @RequestParam(defaultValue = "10") int size) {
    //     Pageable pageable = PageRequest.of(page, size);
    //     return ingredientsRepository.findAll(pageable);
    // }


    // curl -X POST http://localhost:8080/ingredients/create -H "Content-Type: application/json" -d '{
    //     "name": "Tomato",
    //     "type": "Vegetable",
    //     "price": 0.5
    // }'
    
    @PostMapping("/create")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientsRepository.save(ingredient);
    }


}
