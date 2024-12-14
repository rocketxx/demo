package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityPriceOptions;

import lombok.Getter;
import lombok.Setter;

/* Gli ingredienti sono dei ristoranti */
@Document(collection = "ingredients")
@Getter
@Setter
public class Ingredient extends BaseEntityPriceOptions {
    private String name;
    private String tag;        //?enum?
    private String avaibleFor; //?

    /* Only for filtering */
    // private UUID restaurantId;  //ingredienti del ristorante
    @DBRef private Restaurant restaurant;
}
