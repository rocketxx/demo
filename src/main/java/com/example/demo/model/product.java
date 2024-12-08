package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
public class Product extends BaseEntity {
    private String code; //?
    private String description;
}
