package com.example.demo.model;

import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

/* Il contatto è di email, numero di telefono, link social */
@Getter
@Setter
public class Contact extends BaseEntityImageOptions {
    private String email;
    private String phone;
}
