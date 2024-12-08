package com.example.demo.model;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "ingredients")
@Getter
@Setter
public class Ingredient extends BaseEntityImageOptions {
    private String name;
    private String type;        //?enum?
    private String avaibleFor; //?
    private float price;
    private UUID restaurantId;  //ingredienti del ristorante
}
