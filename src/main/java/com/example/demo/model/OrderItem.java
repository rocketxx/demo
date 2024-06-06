package com.example.demo.model;


import java.util.List;

public class OrderItem {

    private String itemId;
    private int quantity;                               
    private List<Ingredient> customizations; //qui i panini/pizze custom
    private MenuItem menuItem; //qui i menu standard predefiniti dal ristorante
    // Getters and setters

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
