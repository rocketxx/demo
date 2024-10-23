package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

@Document(collection = "products")
public class Product extends BaseEntity {

    private String description;
    private String code;

    // Costruttori, getter e setter
    public Product() {
    }

    public Product(String description, String code) {
        this.description = description;
        this.code = code;
    }

    // Getter e setter per id, description e code
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
