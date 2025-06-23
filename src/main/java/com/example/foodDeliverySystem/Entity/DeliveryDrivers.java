package com.example.foodDeliverySystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DeliveryDrivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryDriver_id;

    private String deliveryDriver_name;

    private  String deliveryDriver_phoneNumber;

    private String deliveryDriver_vehicleName;

    @OneToMany(mappedBy = "deliveryDriver", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Orders> ordersList = new ArrayList<>();

    public int getDeliveryDriver_id() {
        return deliveryDriver_id;
    }

    public void setDeliveryDriver_id(int deliveryDriver_id) {
        this.deliveryDriver_id = deliveryDriver_id;
    }

    public String getDeliveryDriver_name() {
        return deliveryDriver_name;
    }

    public void setDeliveryDriver_name(String deliveryDriver_name) {
        this.deliveryDriver_name = deliveryDriver_name;
    }

    public String getDeliveryDriver_phoneNumber() {
        return deliveryDriver_phoneNumber;
    }

    public void setDeliveryDriver_phoneNumber(String deliveryDriver_phoneNumber) {
        this.deliveryDriver_phoneNumber = deliveryDriver_phoneNumber;
    }

    public String getDeliveryDriver_vehicleName() {
        return deliveryDriver_vehicleName;
    }

    public void setDeliveryDriver_vehicleName(String deliveryDriver_vehicleName) {
        this.deliveryDriver_vehicleName = deliveryDriver_vehicleName;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
