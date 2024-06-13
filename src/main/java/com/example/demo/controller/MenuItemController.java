package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mock.MockData;
import com.example.demo.model.MenuItem;
import com.example.demo.repository.MenuItemRepository;

@RestController
@RequestMapping("/menuitems")
public class MenuItemController {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/menu-by-restaurant/{restaurantId}")
    public List<MenuItem> getByRestaurantId(@PathVariable String restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }
        
    @PostMapping("/create")
    public MenuItem createMenuItem(@RequestBody MenuItem MenuItem) {
        MenuItem.setId(UUID.randomUUID().toString());
        return menuItemRepository.save(MenuItem);
    }

    @DeleteMapping("/{id}")
    public MenuItem delete(@PathVariable String id) {
        // Trova il MenuItem con l'ID specificato
        Optional<MenuItem> menuItemOptional = menuItemRepository.findById(id);

        // Verifica se il MenuItem esiste
        if (menuItemOptional.isPresent()) {
            // Se esiste, elimina il MenuItem dal repository
            MenuItem menuItem = menuItemOptional.get();
            menuItemRepository.deleteById(id);
            // Restituisci il MenuItem eliminato
            return menuItem;
        } else {
            // Se il MenuItem non esiste, puoi gestire l'errore in qualche modo,
            // ad esempio restituendo null o generando un'eccezione
            throw new NoSuchElementException("MenuItem not found with id: " + id);
        }
    }

    @PostMapping("/createMock/{idRestaurant}")
    public MenuItem createMock(@PathVariable String idRestaurant) {
        MenuItem margherita = MockData.getMockMenuItem();
        margherita.setRestaurantId(idRestaurant);
        return menuItemRepository.save(margherita);
    }
}
