package com.example.CRUDCapacitacionbackend.repositories;

import com.example.CRUDCapacitacionbackend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer findByCustomerID(String id);
}
