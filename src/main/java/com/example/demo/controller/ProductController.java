package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController 
{
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    // @PostMapping("/test")
    // public Product createTestProduct() {
    //     Product product = new Product("Descrizione del prodotto di test", "ciao");
    //         product.setCode("ciao");
    //         product.setDescription(null);
    //     return productRepository.save(product);
    // }
    @PostMapping("/test")
    public Product test(@RequestBody Product product) {
        if(product == null)
        {
            product = new Product();
            product.setCode("ciao");
            product.setDescription("Description test");
        }
        return productRepository.save(product);
    }
    

    @GetMapping("/findByCode/{code}")
    public ResponseEntity<?> getProductByCode(@PathVariable String code) {
        Product product = productRepository.findByCode(code);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
   
}