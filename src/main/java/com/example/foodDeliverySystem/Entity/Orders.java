package com.example.foodDeliverySystem.Entity;

//Order Entity class

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private LocalDateTime order_date;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnoreProperties("ordersList") // Prevents recursion
    private Restaurants restaurant;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("ordersList") // Prevents recursion
    private Customers customers;



    private String order_status;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

}

