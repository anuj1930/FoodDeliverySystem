package com.example.foodDeliverySystem.Services;

import com.example.foodDeliverySystem.Entity.Menu;
import com.example.foodDeliverySystem.Entity.Restaurants;

import java.util.List;

public interface iRestaurantService {
     Restaurants addRestaurant(Restaurants restaurants);
     List<Restaurants> getAllRestaurants();
     Restaurants getRestaurantById(int restaurant_id);
     Restaurants updateRestaurantDetails(int restaurant_id, Restaurants updateRestaurants);
     String deleteRestaurants(int restaurant_id);
     List<Menu> getMenuWithRestaurantId(int restaurant_id);
}
