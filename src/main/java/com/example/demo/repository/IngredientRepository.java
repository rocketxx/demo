package com.example.demo.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Ingredient;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
    List<Ingredient> findByRestaurantIdOrRestaurantIdIsNull(String restaurantId);

    @Query("{ 'restaurantId' : ?0, 'avaibleFor' : ?1 }")
    List<Ingredient> findByRestaurantIdAndAvaibleFor(String restaurantId, String avaibleFor);
}
