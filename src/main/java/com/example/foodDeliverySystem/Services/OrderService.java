package com.example.foodDeliverySystem.Services;

import com.example.foodDeliverySystem.DTO.OrderDTO;
import com.example.foodDeliverySystem.Entity.Customers;
import com.example.foodDeliverySystem.Entity.DeliveryDrivers;
import com.example.foodDeliverySystem.Entity.Orders;
import com.example.foodDeliverySystem.Entity.Restaurants;
import com.example.foodDeliverySystem.Repository.ICustomerRepository;
import com.example.foodDeliverySystem.Repository.IDeliveryDriverRepositroy;
import com.example.foodDeliverySystem.Repository.IOrderRepository;
import com.example.foodDeliverySystem.Repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{

    @Autowired
    IOrderRepository order_repo;

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    IDeliveryDriverRepositroy deliveryDriverRepositroy;

    @Override
    public Orders addOrderDetails(OrderDTO dto) {
        Restaurants restaurant = restaurantRepository.findById(dto.getRestaurant_id())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Customers customer = customerRepository.findById(dto.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        DeliveryDrivers deliveryDriver = deliveryDriverRepositroy.findById(dto.getDeliveryDriver_id())
                .orElseThrow(() -> new RuntimeException("Driver with this id is not found"));

        Orders order = new Orders();
        order.setOrder_status(dto.getOrder_status());
        order.setOrder_date(dto.getOrder_date());
        order.setRestaurant(restaurant);
        order.setCustomers(customer);
        order.setDeliveryDriver(deliveryDriver);

        return order_repo.save(order);
    }

    @Override
    public Orders getOrderById(int order_id) {
        Orders order = order_repo.findById(order_id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Restaurants restaurant = order.getRestaurant();
        Customers customer = order.getCustomers();
        DeliveryDrivers deliveryDrivers = order.getDeliveryDriver();

        return order;
    }

    @Override
    public Orders updateOrderStatus(int order_id, Orders order){
        Orders order1 = order_repo.findById(order_id).orElseThrow(() -> new RuntimeException("Order with id not found"));

        Restaurants restaurant = order.getRestaurant();
        Customers customer = order.getCustomers();
        DeliveryDrivers deliveryDrivers = order.getDeliveryDriver();

        order1.setOrder_status(order.getOrder_status());
        order1.setOrder_date(order.getOrder_date());
        return order_repo.save(order1);
    }

    @Override
    public String deleteOrder(int order_id, Orders order){
        Orders order1 =  order_repo.findById(order_id).orElseThrow(()->new RuntimeException("order with id not found"));

        order_repo.delete(order1);
        return "Order deleted Successfully";
    }

    @Override
    public Orders assignDriverToOrder(int order_id, int deliveryDriver_id) {
        Orders order = order_repo.findById(order_id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + order_id));

        DeliveryDrivers driver = deliveryDriverRepositroy.findById(deliveryDriver_id)
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + deliveryDriver_id));

        order.setDeliveryDriver(driver);
        return order_repo.save(order);
    }



}
