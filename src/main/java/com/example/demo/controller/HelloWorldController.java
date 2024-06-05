package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, William!";
    }
    @GetMapping("/hello/william")
    public String hello() {
        return "Ciao, William, come stai?";
    }

}
