package com.example.demo.model;

import java.util.List;

import com.example.demo.model.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/* 
 * OrderItem rappresenta l'ordine configurabile per l'utente, che rimarra immutato una volta scelto.
 * 
 * Da considerare:
 *  - cosa succede se si ripropone lo stesso menu e non ci sono ingredienti?
 *
 * */
@Getter
@Setter
public class OrderItem extends BaseEntity {
    /* Quantity selected */
    private int quantity;
    /* Note added */
    private String note;

    /* A new fresh product composed, nested and copied in OrderItem */
    private Product product;
    /* A list of ingredients selected, nested and copied in OrderItem */
    private List<IngredientsPerProducts> orderItems;
}
