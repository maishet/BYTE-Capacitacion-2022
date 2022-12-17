package com.example.CRUDCapacitacionbackend.controllers;

import com.example.CRUDCapacitacionbackend.models.Customer;
import com.example.CRUDCapacitacionbackend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<?> listarCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }

}
