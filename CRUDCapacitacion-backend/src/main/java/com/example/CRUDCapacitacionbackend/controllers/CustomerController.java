package com.example.CRUDCapacitacionbackend.controllers;

import com.example.CRUDCapacitacionbackend.models.Customer;
import com.example.CRUDCapacitacionbackend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> listarCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping("/")
    public void  insertarCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        //return customerService.getCustomers();
    }

    @PutMapping("/")
    public void  editarCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        //return customerService.getCustomers();
    }
    @GetMapping("/{customerid}")
    public Customer obtenerCustomer(@PathVariable("customerid") String customerid){
        return customerService.getCustomer(customerid);
    }

    @DeleteMapping("/{customerid}")
    public void eliminarCustomer(@PathVariable("customerid") String customerid){
        customerService.deteleCustomer(customerid);
    }

}
