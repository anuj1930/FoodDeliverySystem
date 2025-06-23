package com.example.foodDeliverySystem.Repository;

import com.example.foodDeliverySystem.Entity.DeliveryDrivers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryDriverRepositroy extends JpaRepository<DeliveryDrivers, Integer> {
}
