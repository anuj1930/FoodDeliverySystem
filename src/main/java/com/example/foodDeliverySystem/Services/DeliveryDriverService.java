package com.example.foodDeliverySystem.Services;

import com.example.foodDeliverySystem.DTO.OrderDTO;
import com.example.foodDeliverySystem.Entity.DeliveryDrivers;
import com.example.foodDeliverySystem.Entity.Orders;
import com.example.foodDeliverySystem.Repository.IDeliveryDriverRepositroy;
import com.example.foodDeliverySystem.Repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryDriverService implements IDeliveryDriverService{

    @Autowired
    IDeliveryDriverRepositroy deliveryDriver_repo;

    @Autowired
    IOrderRepository orderRepository;

    @Override
    public DeliveryDrivers addDriver(DeliveryDrivers deliveryDrivers) {
        return  deliveryDriver_repo.save(deliveryDrivers);
    }

    @Override
    public List<DeliveryDrivers> getDeliveryDrivers(){
        return deliveryDriver_repo.findAll();
    }

    @Override
    public DeliveryDrivers getDeliveryDriversById(int deliveryDriver_id){
        return deliveryDriver_repo.findById(deliveryDriver_id).orElseThrow(()->new RuntimeException("No delivery driver found by id"));
    }

    @Override
    public List<Orders> getOrdersAssignedToDriver(int deliveryDriver_id) {
        DeliveryDrivers deliveryDriver = deliveryDriver_repo.findById(deliveryDriver_id)
                .orElseThrow(() -> new RuntimeException("Delivery Driver for the specific ID is not found"));

        return deliveryDriver.getOrdersList();
    }

    @Override
    public DeliveryDrivers updateLocationForDriver(int deliveryDriver_id, DeliveryDrivers deliveryDrivers) {
        DeliveryDrivers existingDriver = deliveryDriver_repo.findById(deliveryDriver_id)
                .orElseThrow(() -> new RuntimeException("Delivery Driver with the ID not found"));

        existingDriver.setDeliveryDriver_Location(deliveryDrivers.getDeliveryDriver_Location());

        return deliveryDriver_repo.save(existingDriver);
    }


}
