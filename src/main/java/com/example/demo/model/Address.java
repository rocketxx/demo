package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Address extends BaseEntity {
    private String city;
    private String state;
    private String postalCode;
    private String street;
    private String number;
}
