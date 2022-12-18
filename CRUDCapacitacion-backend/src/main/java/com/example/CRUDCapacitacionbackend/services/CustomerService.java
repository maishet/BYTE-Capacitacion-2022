package com.example.CRUDCapacitacionbackend.services;

import com.example.CRUDCapacitacionbackend.models.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {

     Customer getCustomer(String id);
     Customer updateCustomer(Customer customer);
     Customer saveCustomer(Customer customer);

     List<Customer>getCustomers();

     void deteleCustomer(String id);
}
