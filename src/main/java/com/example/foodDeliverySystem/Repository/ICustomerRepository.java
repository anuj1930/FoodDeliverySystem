package com.example.foodDeliverySystem.Repository;

import com.example.foodDeliverySystem.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customers, Integer> {
}
