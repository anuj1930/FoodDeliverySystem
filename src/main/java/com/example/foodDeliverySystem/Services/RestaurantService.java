package com.example.foodDeliverySystem.Services;

import com.example.foodDeliverySystem.Entity.Restaurants;
import com.example.foodDeliverySystem.Repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class RestaurantService implements iRestaurantService {

    @Autowired
    IRestaurantRepository resto_repo;

    @Override
    public Restaurants addRestaurant(Restaurants restaurants){ return resto_repo.save(restaurants);}

    @Override
    public List<Restaurants> getAllRestaurants() {
        return resto_repo.findAll();
    }

    @Override
    public Restaurants getRestaurantById( int restaurant_id){ return resto_repo.findById(restaurant_id).orElseThrow(() -> new RuntimeException("Restaurant not found by this id"));}

    @Override
    public Restaurants updateRestaurantDetails(int restaurant_id, Restaurants updateRestaurants){
        Restaurants restaurants = resto_repo.findById(restaurant_id).orElseThrow(()->new RuntimeException("Car not found"));
        restaurants.setRestaurant_name(updateRestaurants.restaurant_name);
        restaurants.setRestaurant_address(updateRestaurants.restaurant_address);
        restaurants.setPhoneNumber(updateRestaurants.phoneNumber);

        return resto_repo.save(restaurants);
    }

    @Override
    public String deleteRestaurants(int restaurant_id){
        resto_repo.deleteById(restaurant_id);
        String str = "Car by id " + restaurant_id + " deleted successfully";
        return str;
    }

}
