package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityPriceOptions;
import com.example.demo.model.common.OrderState;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * !!If an Order has closed, it is immutable!!
  */
@Document(collection = "orders")
@Getter
@Setter
public class Order extends BaseEntityPriceOptions {
    /* User reference, mutable component */
    @DBRef private User user;
    /* Restaurant reference, mutable component */
    @DBRef private Restaurant restaurant;

    /* Delivery items, immutable component */
    private List<OrderItem> orderItems;
    /* Delivery address, immutable component */
    private Address address;
    /* Delivery date, immutable component */
    private Date orderDate;
    /* Delivery state, immutable component */
    private OrderState orderState;
}