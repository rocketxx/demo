package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enumerator.RestaurantType;
import com.example.demo.model.beans.Address;
import com.example.demo.model.beans.Contact;
import com.example.demo.model.beans.WorkingHour;
import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Document(collection = "restaurants")
@Getter
@Setter
public class Restaurant extends BaseEntityImageOptions {
    private RestaurantType type;

    private String name;
    private String businessName;
    private String vatNumber;
    private boolean opened;

    /*
     * > ciò che è legato in maniera UNIVOCA al ristorante, non ha una zona di trasparenza con l'app
     * > ciò che è in numero finito
     * > ciò che è utile alla ricerca del ristorante
    */
    /* Contacts as email, phonenumber*/
    private List<Contact> contacts;
    /* Contacts as email, phonenumber*/
    private List<Address> addresses;
    /* Restaurant can configure workingHours */
    private List<WorkingHour> workingHours;
}