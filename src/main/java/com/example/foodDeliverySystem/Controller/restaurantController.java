package com.example.foodDeliverySystem.Controller;

import com.example.foodDeliverySystem.Entity.Restaurants;
import com.example.foodDeliverySystem.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class restaurantController {

    @Autowired
    RestaurantService restoService;

    @PostMapping("/add")
    public Restaurants addRestaurant(@RequestBody Restaurants restaurants){
        return restoService.addRestaurant(restaurants);
    }

    @GetMapping
    public List<Restaurants> getAllRestaurants(){
        return restoService.getAllRestaurants();
    }

    @GetMapping("/{restaurant_id}")
    public Restaurants getRestaurantById(@PathVariable int restaurant_id){
//        System.out.println("Fetching restaurant with ID: " + restaurant_id);
        return restoService.getRestaurantById(restaurant_id);
    }

    @PutMapping("/{restaurant_id}")
    public Restaurants updateRestaurantDetails(@PathVariable int restaurant_id, @RequestBody Restaurants updateRestaurants){
        return restoService.updateRestaurantDetails(restaurant_id,updateRestaurants);
    }

    @DeleteMapping("/{restaurant_id}")
    public String deleteRestaurants(@PathVariable  int restaurant_id){
        return  restoService.deleteRestaurants(restaurant_id);
    }

}
