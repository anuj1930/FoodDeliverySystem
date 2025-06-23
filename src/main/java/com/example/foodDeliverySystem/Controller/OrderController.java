package com.example.foodDeliverySystem.Controller;


// imports of packages

import com.example.foodDeliverySystem.DTO.OrderDTO;
import com.example.foodDeliverySystem.Entity.Orders;
import com.example.foodDeliverySystem.Services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService order_service;

    @PostMapping("/add")
    public Orders addOrderDetails(@RequestBody OrderDTO orderDto){
        return order_service.addOrderDetails(orderDto);
    }

    @GetMapping("/{order_id}")
    public Orders getOrderById(@PathVariable int order_id) {
        return order_service.getOrderById(order_id);
    }

    @PutMapping("/{order_id}/status")
    public Orders updateOrderStatus(@PathVariable int order_id, @RequestBody Orders order){
        return order_service.updateOrderStatus(order_id,order);
    }

    @DeleteMapping("/{order_id}")
    public String deleteOrder(@PathVariable int order_id, Orders order){
        return order_service.deleteOrder(order_id, order);
    }

}
