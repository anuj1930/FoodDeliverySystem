package com.example.foodDeliverySystem.Repository;

import com.example.foodDeliverySystem.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository class

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Integer> {

}
