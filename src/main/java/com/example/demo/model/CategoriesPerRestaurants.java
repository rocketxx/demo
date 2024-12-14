package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/* Le categorie le decide l'app ed appartengono a più ristoranti */
@Document(collection = "categories_per_restaurants")
@Getter
@Setter
public class CategoriesPerRestaurants extends BaseEntity {
    @DBRef private Restaurant restaurant;
    @DBRef private Category category;
}