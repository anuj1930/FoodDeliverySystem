package com.example.foodDeliverySystem.Controller;


import com.example.foodDeliverySystem.Entity.Menu;
import com.example.foodDeliverySystem.Entity.Restaurants;
import com.example.foodDeliverySystem.Services.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class MenuController {

    @Autowired
    public IMenuService menu_serve;


    @PostMapping("/{restaurant_id}/menu")
    public Menu addMenu(@PathVariable int restaurant_id, @RequestBody Menu menu){
        return menu_serve.addMenu(restaurant_id,menu);
    }

    @GetMapping("/{restaurant_id}/menu")
    public List<Menu> getMenuByRestaurant(@PathVariable int restaurant_id) {
        return menu_serve.getMenuByRestaurant(restaurant_id);
    }


    @PutMapping("/{restaurantId}/menu/{menu_id}")
    public Menu updateMenuItem(@PathVariable int restaurantId, @PathVariable int menu_id, @RequestBody Menu updatedMenu) {
        return menu_serve.updateMenuItem(restaurantId, menu_id, updatedMenu);
    }


    @DeleteMapping("/{restaurant_id}/menu/{menu_id}")
    public Menu deleteMenuItem(@PathVariable int restaurant_id, @PathVariable int menu_id) {
           return menu_serve.deleteMenuById(restaurant_id, menu_id);
    }


}
