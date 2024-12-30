package com.example.demo.model;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.beans.Address;
import com.example.demo.model.beans.Contact;
import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
public class User extends BaseEntityImageOptions {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    
    /* Only user can modify his contacts */
    private List<Contact> contacts;
    /* Only user can modify his addresses */
    private List<Address> addresses;
}
