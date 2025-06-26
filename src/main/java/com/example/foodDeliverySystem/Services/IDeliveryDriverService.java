package com.example.foodDeliverySystem.Services;

import com.example.foodDeliverySystem.DTO.OrderDTO;
import com.example.foodDeliverySystem.Entity.DeliveryDrivers;
import com.example.foodDeliverySystem.Entity.Orders;

import java.util.List;

public interface IDeliveryDriverService {
    DeliveryDrivers addDriver(DeliveryDrivers deliveryDrivers);
    List<DeliveryDrivers> getDeliveryDrivers();
    DeliveryDrivers getDeliveryDriversById(int deliveryDriver_id);
    List<Orders> getOrdersAssignedToDriver(int deliveryDriver_id);
    DeliveryDrivers updateLocationForDriver(int deliveryDriver_id, DeliveryDrivers deliveryDrivers);
}
