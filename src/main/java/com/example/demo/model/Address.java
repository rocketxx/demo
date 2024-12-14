package com.example.demo.model;

import org.springframework.data.geo.Point;

import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address extends BaseEntityImageOptions {
    private String city;
    private String state;
    private String postalCode;
    private String street;
    private String number;

    /* Geolocation, mapping specific address */
    private Point point;
}
