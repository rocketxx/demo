package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntityImageOptions;

import lombok.Getter;
import lombok.Setter;

/* Tags sono dell'app, hanno senso per indicare celiachia, vegani, etc? */
@Document(collection = "tags")
@Getter
@Setter
public class Tag extends BaseEntityImageOptions {
    /* Name of category */
    private String name;
}