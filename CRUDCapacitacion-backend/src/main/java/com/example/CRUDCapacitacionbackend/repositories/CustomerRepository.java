package com.example.CRUDCapacitacionbackend.repositories;

import com.example.CRUDCapacitacionbackend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    //List<Customer> findBycompany_name(String company_name);
}
