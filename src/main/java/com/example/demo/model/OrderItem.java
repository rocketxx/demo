package com.example.demo.model;


import java.util.List;

import org.springframework.data.annotation.Id;

public class OrderItem {
    @Id
    private String itemId;
    private String restaurantId;
    private String userId;
    private int quantity;                               
    private List<Ingredient> customizations; //qui i panini/pizze custom
    private MenuItem menuItem; //qui i menu standard predefiniti dal ristorante
    private String note;
    private String type; 
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public String getItemId() {
        return itemId;
    }                                    

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Ingredient> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<Ingredient> customizations) {
        this.customizations = customizations;
    }
}
