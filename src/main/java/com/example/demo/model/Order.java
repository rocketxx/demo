package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityImageOptions;
import com.example.demo.model.common.OrderState;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Document(collection = "orders")
@Getter
@Setter
public class Order extends BaseEntityImageOptions {
    @DBRef
    private User user;
    @DBRef
    private Restaurant restaurant;

    //? ha senso renderli immutabili ?
    private List<OrderItem> items;

    private Address address;
    private Date orderDate;
    private float price;
    private OrderState orderState;
}