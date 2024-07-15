package com.example.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enumerator.RestaurantType;

import java.util.List;

@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;
    private String name;
    private RestaurantType type;
    private String address;
    private String phone;
    private Boolean active; //indica se è attivo o no
    private Boolean opened; //indica se il ristorante è aperto o chiuso
    private String imageUrl; //indica se il ristorante è aperto o chiuso
    private List<MenuItem> menu;
    private List<WorkingHours> workingHours;
    private List<FilterItem> filterItems; // sarebbero gli item attivi disponibili: pizze,bevande,panini,insalate
    public List<FilterItem> getFilterItems() {
        return filterItems;
    }

    public void setFilterItems(List<FilterItem> filterItems) {
        this.filterItems = filterItems;
    }

    // Getters and setters
    public List<WorkingHours> getWorkingHours() {
        return workingHours;
    }
    
    public void setWorkingHours(List<WorkingHours> workingHours) {
        this.workingHours = workingHours;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestaurantType getType() {
        return type;
    }

    public void setType(RestaurantType type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }
}
