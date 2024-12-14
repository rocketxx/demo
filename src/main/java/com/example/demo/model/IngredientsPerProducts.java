package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/* Gli ingredienti sono comuni a più prodotti */
@Document(collection = "ingredients_per_products")
@Getter
@Setter
public class IngredientsPerProducts extends BaseEntity {
    @DBRef private Ingredient ingredient;
    @DBRef private Product product;
}