package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll(); 
    }

    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable String id) throws Exception {
        // return restaurantRepository.findAll(); 
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            return optionalRestaurant.get();
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }

    @PostMapping("/create")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // @PostMapping("/createMock")
    // public Restaurant createMock() {
    //     Address addr = new Address();
    //             addr.setStreet("via cappuccini 174");
    //     Restaurant res = new Restaurant();
    //                 res.setName("Willy Burger");
    //                 res.setPhone("3383831834");
    //                 res.setType(RestaurantType.BREAD);
    //                 res.setEnabled(true);
    //                 res.setOpened(true);
    //                 res.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-tUn7mE2S4p8_xMP_pCYtfhsfeXMOO6FdVA&s");
        
    //     WorkingHours mondayHours = new WorkingHours();
    //                 mondayHours.setDayOfWeek("Monday");
    //                 mondayHours.setOpeningTime(LocalTime.of(8, 0));
    //                 mondayHours.setClosingTime(LocalTime.of(18, 0));
    //                 mondayHours.setClosed(false);
    //                 mondayHours.setHolidays(Arrays.asList("2024-07-04", "2024-12-25"));

    //     WorkingHours tuesdayHours = new WorkingHours();
    //                 tuesdayHours.setDayOfWeek("Tuesday");
    //                 tuesdayHours.setOpeningTime(LocalTime.of(9, 0));
    //                 tuesdayHours.setClosingTime(LocalTime.of(20, 0));
    //                 tuesdayHours.setClosed(false);
    //                 tuesdayHours.setHolidays(Arrays.asList());

    //     WorkingHours wednesdayHours = new WorkingHours();
    //                 wednesdayHours.setDayOfWeek("Wednesday");
    //                 wednesdayHours.setOpeningTime(LocalTime.of(10, 0));
    //                 wednesdayHours.setClosingTime(LocalTime.of(16, 0));
    //                 wednesdayHours.setClosed(true);
    //                 wednesdayHours.setHolidays(Arrays.asList());

    //     WorkingHours thursdayHours = new WorkingHours();
    //                 thursdayHours.setDayOfWeek("Thursday");
    //                 thursdayHours.setOpeningTime(LocalTime.of(8, 30));
    //                 thursdayHours.setClosingTime(LocalTime.of(17, 30));
    //                 thursdayHours.setClosed(false);
    //                 thursdayHours.setHolidays(Arrays.asList());

    //     WorkingHours fridayHours = new WorkingHours();
    //                 fridayHours.setDayOfWeek("Friday");
    //                 fridayHours.setOpeningTime(LocalTime.of(7, 0));
    //                 fridayHours.setClosingTime(LocalTime.of(19, 0));
    //                 fridayHours.setClosed(false);
    //                 fridayHours.setHolidays(Arrays.asList());

    //     WorkingHours saturdayHours = new WorkingHours();
    //                 saturdayHours.setDayOfWeek("Saturday");
    //                 saturdayHours.setOpeningTime(LocalTime.of(12, 0));
    //                 saturdayHours.setClosingTime(LocalTime.of(22, 0));
    //                 saturdayHours.setClosed(false);
    //                 saturdayHours.setHolidays(Arrays.asList());

    //     WorkingHours sundayHours = new WorkingHours();
    //                 sundayHours.setDayOfWeek("Sunday");
    //                 sundayHours.setOpeningTime(LocalTime.of(10, 30));
    //                 sundayHours.setClosingTime(LocalTime.of(15, 30));
    //                 sundayHours.setClosed(true);
    //                 sundayHours.setHolidays(Arrays.asList());

    //     // Aggiungi le istanze di WorkingHours a una lista
    //     List<WorkingHours> workingHoursList = Arrays.asList(
    //         mondayHours, tuesdayHours, wednesdayHours,
    //         thursdayHours, fridayHours, saturdayHours, sundayHours
    //     );

    //     // Crea l'istanza di Restaurant
    //             res.setWorkingHours(workingHoursList);
    //     return restaurantRepository.save(res);
    // }

    @PutMapping("/update/{id}")
    public Restaurant updateRestaurant(@PathVariable String id, @RequestBody Restaurant restaurantDetails) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (!optionalRestaurant.isPresent())
            throw new Exception("Restaurant not found with id " + id);

        return restaurantRepository.save(restaurantDetails);
    }
    // COLLAUDATA ✅ 
    //endpoint utile se si vuole tagliare fuori un ristorante dalla visualizzazione in home
    @PutMapping("/change-status/{id}")
    public Restaurant activeStatusRestaurant(@PathVariable String id) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant existingRestaurant = optionalRestaurant.get();
                       existingRestaurant.setEnabled(!existingRestaurant.isEnabled()); //cambia lo stato di attivazione
            return restaurantRepository.save(existingRestaurant);
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }

    @PutMapping("/opened/{id}")
    public Restaurant openedRestaurant(@PathVariable String id) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant existingRestaurant = optionalRestaurant.get();
                       existingRestaurant.setOpened(!existingRestaurant.isOpened()); //cambia lo stato di attivazione
            return restaurantRepository.save(existingRestaurant);
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable String id) throws Exception {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            restaurantRepository.delete(optionalRestaurant.get());
            return "Restaurant deleted with id " + id;
        } else {
            // Handle the case where the restaurant is not found
            // This can be customized based on your application's requirements
            throw new Exception("Restaurant not found with id " + id);
        }
    }
}
