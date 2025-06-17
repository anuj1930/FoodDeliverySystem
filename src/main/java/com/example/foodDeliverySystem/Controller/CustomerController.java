package com.example.foodDeliverySystem.Controller;

import com.example.foodDeliverySystem.Entity.Customers;
import com.example.foodDeliverySystem.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    public CustomerService cust_service;

    @PostMapping("/add")
    public Customers addCustomer(@RequestBody Customers customers){
        return cust_service.addCustomer(customers);
    }

    @GetMapping("/")
    public List<Customers> getCustomers(){
        return cust_service.getCustomers();
    }

    @GetMapping("/{customer_id}")
    public Customers getCustomersById(@PathVariable int customer_id){
        return cust_service.getCustomersById(customer_id);
    }

    @PutMapping("/{customer_id}")
    public Customers updateCustomer(@PathVariable int customer_id, @RequestBody Customers customers){
        return cust_service.updateCustomer(customer_id,customers);
    }
}
