package com.example.foodDeliverySystem.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int menu_id;

    public String menu_name;

    public String menu_description;

    public double menu_price;

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_description() {
        return menu_description;
    }

    public void setMenu_description(String menu_description) {
        this.menu_description = menu_description;
    }

    public double getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(double menu_price) {
        this.menu_price = menu_price;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurant;

}
