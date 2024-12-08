package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mock.MockData;
import com.example.demo.model.MenuItem;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("/all")
    public List<Order> getAllOrderss() {
        return orderRepository.findAll(); 
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
    
    @PostMapping("/createMock")
    public Order createOrderMock() {
        Order order = new Order();
        List<OrderItem> orderItemList = new ArrayList<>();
        // Aggiungere elementi alla lista
        OrderItem orderItem = new OrderItem();
        MenuItem margherita = MockData.getMockMenuItem();
        orderItem.setMenuItem(margherita);
        orderItemList.add(orderItem);
        order.setItems(orderItemList);
        order.setRestaurant(new Restaurant());
        // order.setRestaurantId("333344444");
        order.setPrice(order.getPrice());
        // order.setUserId("5555577777");
        order.setUser(new User());
        return orderRepository.save(order);
    }
}
