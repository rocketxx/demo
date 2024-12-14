package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

/* I tags vanno su più ingredienti, gli ingredienti hanno più tags */
@Document(collection = "tags_per_ingredients")
@Getter
@Setter
public class TagsPerIngredients extends BaseEntityImageOptions {
    @DBRef private Tag tag;
    @DBRef private Ingredient ingredient;
}