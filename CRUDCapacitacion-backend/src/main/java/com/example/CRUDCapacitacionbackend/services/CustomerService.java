package com.example.CRUDCapacitacionbackend.services;

import com.example.CRUDCapacitacionbackend.models.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {

     Customer saveCustomer(Customer customer);

     Set<Customer> getCustomers();

     void deteleCustomer(String id);
}
