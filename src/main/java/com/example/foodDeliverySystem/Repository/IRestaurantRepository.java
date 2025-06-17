package com.example.foodDeliverySystem.Repository;

import com.example.foodDeliverySystem.Entity.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurants, Integer> {
}
