package com.example.demo.model;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
public class User extends BaseEntityImageOptions {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    
    /* Only user can modify his contacts */
    private List<Contact> contacts;
}
