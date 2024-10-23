package com.example.demo.model;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

@Document
public class Cart extends BaseEntity {
    private String idRestaurant;
    private String idUser;
    private List<OrderItem> orderItems; //sono ancora item, quando l'utente esegue l'ordine dal carrello, verrà creata una entità "Order", che conterrà  List<OrderItem>
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Constructors, getters, and setters
    public Cart() {}

    public Cart(
        String idRestaurant,
        String idUser, 
        List<MenuItem> menuItems, 
        List<OrderItem> orderItems
    ) {
        this.idRestaurant = idRestaurant;
        this.idUser = idUser;
        this.orderItems = orderItems;
    }

    // Getters and setters
    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

