package com.example.foodDeliverySystem.Services;


import com.example.foodDeliverySystem.Entity.Menu;

import java.util.List;

public interface IMenuService  {

    Menu addMenu(int restaurant_id, Menu menu);
    List<Menu> getMenuByRestaurant(int restaurant_id);
    Menu updateMenuItem(int restaurant_id, int menu_id, Menu updatedMenu);
    Menu deleteMenuById(int restaurant_id, int menu_id);

}
