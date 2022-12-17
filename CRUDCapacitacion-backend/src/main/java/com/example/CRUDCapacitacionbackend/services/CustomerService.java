package com.example.CRUDCapacitacionbackend.services;

import com.example.CRUDCapacitacionbackend.models.Customer;

import java.util.Set;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Set<Customer> getCustomers();

    public void deteleCustomer(String id);
}
