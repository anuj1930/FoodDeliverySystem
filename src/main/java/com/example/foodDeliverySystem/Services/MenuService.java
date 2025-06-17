package com.example.foodDeliverySystem.Services;


import com.example.foodDeliverySystem.Entity.Menu;
import com.example.foodDeliverySystem.Entity.Restaurants;
import com.example.foodDeliverySystem.Repository.IMenuRepository;
import com.example.foodDeliverySystem.Repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements  IMenuService{
    @Autowired
    IMenuRepository menu_repo;

    @Autowired
    IRestaurantRepository rest_repo;

    @Override
    public Menu addMenu(int restaurant_id, Menu menu){
        Restaurants restaurants = rest_repo.findById(restaurant_id).orElseThrow(() -> new RuntimeException("No restaurant found with this id."));
        menu.setRestaurant(restaurants);
        return menu_repo.save(menu);
    }

    @Override
    public List<Menu> getMenuByRestaurant(int restaurant_id) {
        Restaurants restaurant = rest_repo.findById(restaurant_id)
                .orElseThrow(() -> new RuntimeException("No restaurant found with this id."));
        return menu_repo.findMenusByRestaurantId(restaurant_id);
    }


    @Override
    public Menu updateMenuItem(int restaurant_id, int menu_id, Menu updatedMenu) {
        Restaurants restaurant = rest_repo.findById(restaurant_id).orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Menu existingMenu = menu_repo.findById(menu_id).orElseThrow(() -> new RuntimeException("Menu item not found"));

        if (existingMenu.getRestaurant().getRestaurant_id() != restaurant_id) {
            throw new RuntimeException("Menu item does not belong to the specified restaurant");
        }
        existingMenu.setMenu_name(updatedMenu.getMenu_name());
        existingMenu.setMenu_description(updatedMenu.getMenu_description());
        existingMenu.setMenu_price(updatedMenu.getMenu_price());
        return menu_repo.save(existingMenu);
     }

    @Override
    public Menu deleteMenuById(int restaurant_id, int menu_id) {
        Restaurants restaurant = rest_repo.findById(restaurant_id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Menu menu = menu_repo.findMenuByRestaurantAndMenuId(restaurant_id, menu_id)
                .orElseThrow(() -> new RuntimeException("Menu item not found or does not belong to this restaurant"));

        menu_repo.delete(menu);
        return menu;
    }

}
