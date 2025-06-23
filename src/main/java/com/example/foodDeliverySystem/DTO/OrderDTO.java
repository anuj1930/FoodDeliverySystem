package com.example.foodDeliverySystem.DTO;

//Order DTO Class

import java.time.LocalDateTime;

public class OrderDTO {

    private int order_id;
    private String order_status;
    private LocalDateTime order_date;
    private int restaurant_id;
    private int customer_id;
    private int deliveryDriver_id;


    // Getters and Setters
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

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getDeliveryDriver_id() {
        return deliveryDriver_id;
    }

    public void setDeliveryDriver_id(int deliveryDriver_id) {
        this.deliveryDriver_id = deliveryDriver_id;
    }
}
