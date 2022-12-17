package com.example.CRUDCapacitacionbackend;

import com.example.CRUDCapacitacionbackend.models.Customer;
import com.example.CRUDCapacitacionbackend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudCapacitacionBackendApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(CrudCapacitacionBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//prueba
//		Customer customer = new Customer();
//		customer.setCustomerID("ABCDE");
//		customer.setCompanyName("Empresa ABCDE");
//		customer.setContactName("nombre");
//		customer.setContactTitle("titulo");
//		customer.setCountry("Peru");
//		customer.setPhone("(11) 555-7647");
//
//		Customer customersave = customerService.saveCustomer(customer);
//		System.out.println(customersave.getCompanyName());
	}
}
