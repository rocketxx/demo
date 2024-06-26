package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/by-id/{id}")
    public Optional<Ingredient> getIngredientById(@PathVariable String id) {
        return ingredientsRepository.findById(id); 
    }

    @GetMapping("/ingredients-by-restaurant/{restaurantId}")
    public List<Ingredient> getIngredientsByRestaurantIdOrNull(@PathVariable String restaurantId) {
        return ingredientsRepository.findByRestaurantIdOrRestaurantIdIsNull(restaurantId);
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
        ingredient.setId(UUID.randomUUID().toString());
        return ingredientsRepository.save(ingredient);
    }

    @PutMapping("/update/{id}")
public ResponseEntity<Ingredient> updateIngredient(@PathVariable String id, @RequestBody Ingredient ingredientDetails) {
    Optional<Ingredient> optionalIngredient = ingredientsRepository.findById(id);
    if (!optionalIngredient.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    Ingredient existingIngredient = optionalIngredient.get();
    existingIngredient.setName(ingredientDetails.getName());
    existingIngredient.setActive(ingredientDetails.isActive());
    existingIngredient.setType(ingredientDetails.getType());
    existingIngredient.setPrice(ingredientDetails.getPrice());

    Ingredient updatedIngredient = ingredientsRepository.save(existingIngredient);
    return ResponseEntity.ok(updatedIngredient);
}


    @PostMapping("/createMock")
    public Ingredient createMockIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setRestaurantId(null);
        ingredient.setName("test 2null");
        ingredient.setPrice(0.80);
        ingredient.setType("nessuno");
        return ingredientsRepository.save(ingredient);
    }
    


}
