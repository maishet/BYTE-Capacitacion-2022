package com.example.CRUDCapacitacionbackend.services.impl;

import com.example.CRUDCapacitacionbackend.models.Customer;
import com.example.CRUDCapacitacionbackend.repositories.CustomerRepository;
import com.example.CRUDCapacitacionbackend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer getCustomer(String id) {
        //return null;
        return customerRepository.findByCustomerID(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);

    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deteleCustomer(String id) {
        Customer customer = new Customer();
        customer.setCustomerID(id);
        customerRepository.delete(customer);
    }
}
