package com.example.demo.model;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class OrderItem extends BaseEntity {
    private List<Ingredient> ingredients; //qui i panini/pizze custom
    private int quantity;
    private String note;
    private String type;
    private String userId;  //ordini di un utente

    private MenuItem menuItem; //qui i menu standard predefiniti dal ristorante //?
}
