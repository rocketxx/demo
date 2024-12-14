package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

/* Categorie sono dell'app */
@Document(collection = "categories")
@Getter
@Setter
public class Category extends BaseEntityImageOptions {
    /* Level of category */
    private String level;
    /* Name of category */
    private String name;
}