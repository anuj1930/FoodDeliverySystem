package com.example.foodDeliverySystem.Repository;

import com.example.foodDeliverySystem.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMenuRepository extends JpaRepository<Menu, Integer> {
    @Query("SELECT m FROM Menu m WHERE m.restaurant.restaurant_id = :restaurantId")
    List<Menu> findMenusByRestaurantId(@Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM Menu m WHERE m.menu_id = :menu_id AND m.restaurant.restaurant_id = :restaurant_id")
    Optional<Menu> findMenuByRestaurantAndMenuId(@Param("restaurant_id") int restaurant_id, @Param("menu_id") int menu_id);

}
