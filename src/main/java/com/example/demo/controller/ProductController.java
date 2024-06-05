package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController 
{

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }
    @PostMapping("/test")
    public product createTestProduct() {
        product product = new product("Descrizione del prodotto di test", "ciao");
        return productRepository.save(product);
    }

    @GetMapping("/findByCode/{code}")
    public ResponseEntity<?> getProductByCode(@PathVariable String code) {
        product product = productRepository.findByCode(code);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
   
}