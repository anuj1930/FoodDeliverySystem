package com.example.foodDeliverySystem.Services;

import com.example.foodDeliverySystem.DTO.OrderDTO;
import com.example.foodDeliverySystem.Entity.Orders;

public interface IOrderService {
    Orders addOrderDetails(OrderDTO orderDto);
    Orders getOrderById(int order_id) ;
    Orders updateOrderStatus(int order_id, Orders order);
    String deleteOrder(int order_id, Orders order);

}
