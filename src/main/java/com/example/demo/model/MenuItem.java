package com.example.demo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enumerator.ProductType;
import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class MenuItem extends BaseEntityImageOptions {
    private String name;
    private String description;
    private List<Ingredient> ingredients; //questa lista è utile in caso di menu custom 
    private String restaurantId;
    private ProductType productType; 
    private String type;
    private float price;
}
