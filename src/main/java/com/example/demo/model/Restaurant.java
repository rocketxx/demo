package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enumerator.RestaurantType;
import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Document(collection = "restaurants")
@Getter
@Setter
public class Restaurant extends BaseEntityImageOptions {
    private String name;
    private RestaurantType type;
    private Address address;
    private String phone;
    private boolean opened; //indica se il ristorante è aperto o chiuso
    private List<MenuItem> menu; //?
    private List<WorkingHours> workingHours;
    private List<Category> categories; // sarebbero gli item attivi disponibili: pizze,bevande,panini,insalate
}