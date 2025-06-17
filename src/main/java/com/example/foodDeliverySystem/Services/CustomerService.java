package com.example.foodDeliverySystem.Services;

import com.example.foodDeliverySystem.Entity.Customers;
import com.example.foodDeliverySystem.Repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepository cust_repo;

    @Override
    public Customers addCustomer(Customers customers){
        return cust_repo.save(customers);
    }

    @Override
    public List<Customers> getCustomers(){
        return cust_repo.findAll();
    }

    @Override
    public Customers getCustomersById(int customer_id){
        return cust_repo.findById(customer_id).orElseThrow( () -> new RuntimeException("Customer ID not found"));
    }

    @Override
    public Customers updateCustomer(int customer_id, Customers customers){
        Customers customers1 = cust_repo.findById(customer_id).orElseThrow(()-> new RuntimeException("Customer ID not found"));

        customers1.setCustomer_name(customers.getCustomer_name());
        customers1.setCustomer_email(customers.getCustomer_email());
        customers1.setCustomer_phone_number(customers.getCustomer_phone_number());

        return cust_repo.save(customers1);
    }


}
