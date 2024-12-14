package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enumerator.ProductType;
import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

/* Questo prodotto lo configura il ristorante secondo gli ingredienti di base che ha creato */
@Document(collection = "products")
@Getter
@Setter
public class Product extends BaseEntityImageOptions {
    /* Code unique referral */
    private String code;
    private String name;
    private String description;
    private ProductType type; 

    // gli ingredienti sono centrali rispetto ai prodotti che si vanno a comporre
    // @DBRef private List<Ingredient> ingredients; //qui i panini/pizze custom
    @DBRef private Restaurant restaurant;
}
