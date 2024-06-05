package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class product {

    @Id
    private String id;
    private String description;
    private String code;

    // Costruttori, getter e setter
    public product() {
    }

    public product(String description, String code) {
        this.description = description;
        this.code = code;
    }

    // Getter e setter per id, description e code
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
