package com.example.demo.model;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Cart extends BaseEntity {
    @DBRef
    private Restaurant restaurant;
    @DBRef
    private User user;
    private List<OrderItem> orderItems; //sono ancora item, quando l'utente esegue l'ordine dal carrello, verrà creata una entità "Order", che conterrà  List<OrderItem>
    private String status;
}

