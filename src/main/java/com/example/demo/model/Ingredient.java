package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

@Document(collection = "ingredients")
public class Ingredient extends BaseEntity {
    private String restaurantId;
    private String name;
    private String type;
    private double price;
    private boolean isActive; //se il prodotto è finito è possibile disattivarlo
    private String avaibleFor;
    
    // Getters and setters

    public String getAvaibleFor() {
        return avaibleFor;
    }

    public void setAvaibleFor(String avaibleFor) {
        this.avaibleFor = avaibleFor;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
