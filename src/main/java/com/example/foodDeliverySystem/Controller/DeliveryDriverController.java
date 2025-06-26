package com.example.foodDeliverySystem.Controller;

import com.example.foodDeliverySystem.Entity.DeliveryDrivers;
import com.example.foodDeliverySystem.Entity.Orders;
import com.example.foodDeliverySystem.Services.DeliveryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveryDriver")
public class DeliveryDriverController {

    @Autowired
    DeliveryDriverService deliveryDriverService;

    @PostMapping("/add")
    public DeliveryDrivers addDriver(@RequestBody DeliveryDrivers deliveryDrivers){
        return deliveryDriverService.addDriver(deliveryDrivers);
    }

    @GetMapping("/drivers")
    public List<DeliveryDrivers> getDeliveryDrivers(){
        return deliveryDriverService.getDeliveryDrivers();
    }

    @GetMapping("/drivers/{deliveryDriver_id}")
    public DeliveryDrivers getDeliveryDriversById(@PathVariable int deliveryDriver_id){
        return deliveryDriverService.getDeliveryDriversById(deliveryDriver_id);
    }

    @GetMapping("{deliveryDriver_id}/orders")
    public List<Orders> getOrdersAssignedToDriver(@PathVariable int deliveryDriver_id){
        return  deliveryDriverService.getOrdersAssignedToDriver(deliveryDriver_id);
    }

    @PutMapping("/{deliveryDriver_id}/location")
    public  DeliveryDrivers updateLocationForDriver(@PathVariable int deliveryDriver_id, @RequestBody DeliveryDrivers deliveryDrivers){
        return  deliveryDriverService.updateLocationForDriver(deliveryDriver_id,deliveryDrivers);
    }
}

