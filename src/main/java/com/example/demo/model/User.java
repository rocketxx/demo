package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Document(collection = "users")
@Getter
@Setter
public class User extends BaseEntityImageOptions {
    private String firstName;
    private String lastName;
    private List<Contact> contacts;
    private List<Address> addresses;
}
