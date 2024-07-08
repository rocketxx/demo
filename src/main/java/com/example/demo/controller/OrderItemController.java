package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ingredient;
import com.example.demo.model.MenuItem;
import com.example.demo.model.OrderItem;
import com.example.demo.repository.OrderItemRepository;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/get-by-user/{userId}")
    public List<OrderItem> getByRestaurantId(@PathVariable String userId) {
        return orderItemRepository.findByUserId(userId);
    }

            @GetMapping("/{id}")
    public OrderItem getById(@PathVariable String id) throws Exception {
        Optional<OrderItem> optionalItem = orderItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new Exception("Order item not found with id " + id);
        }
    }

    @PutMapping("/update/{id}")
public ResponseEntity<OrderItem> update(@PathVariable String id, @RequestBody OrderItem OrderItemDetails) {
    Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(id);
    if (!optionalOrderItem.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    OrderItem existingOrderItem = optionalOrderItem.get();
    existingOrderItem.setMenuItem(OrderItemDetails.getMenuItem());
    existingOrderItem.setCustomizations(OrderItemDetails.getCustomizations());
    existingOrderItem.setNote(OrderItemDetails.getNote());
    existingOrderItem.setQuantity(OrderItemDetails.getQuantity());

    OrderItem updatedOrderItem = orderItemRepository.save(existingOrderItem);
    return ResponseEntity.ok(updatedOrderItem);
}

    @PostMapping("/create")
    public OrderItem createOrder(@RequestBody OrderItem order) {
        order.setItemId(UUID.randomUUID().toString());
        return orderItemRepository.save(order);
    }

    @DeleteMapping("/delete/{itemId}")
    public String deleteOrderItem(@PathVariable String itemId) throws Exception {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(itemId);
        if (optionalOrderItem.isPresent()) {
            orderItemRepository.delete(optionalOrderItem.get());
            return "OrderItem deleted with id " + itemId;
        } else {
            // Handle the case where the OrderItem is not found
            // This can be customized based on your application's requirements
            throw new Exception("OrderItem not found with id " + itemId);
        }
    }

}
