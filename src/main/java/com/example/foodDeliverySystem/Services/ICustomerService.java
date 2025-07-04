package com.example.foodDeliverySystem.Services;

import com.example.foodDeliverySystem.Entity.Customers;
import com.example.foodDeliverySystem.Entity.Orders;

import java.util.List;

public interface ICustomerService {
    Customers addCustomer(Customers customers);
    List<Customers> getCustomers();
    Customers getCustomersById(int customer_id);
    Customers updateCustomer(int customer_id, Customers customers);
    String deleteCustomerById(int customer_id);
    List<Orders> getOrdersByCustomerId(int customer_id);
}
