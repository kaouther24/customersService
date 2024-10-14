package com.bank.customer.controller;

import com.bank.customer.service.CustomerService;
import com.bank.customer.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Application is healthy");
    }

    @GetMapping("/byId/{customerUuid}")
    public Optional<Customer> getCustomerByUuid(@PathVariable String customerUuid) throws IOException {

        return customerService.findCustomerByUuid(customerUuid);
    }

    @GetMapping("/byNameAndSurname/{name}/{surname}")
    public List<Customer> getCustomerByName(@PathVariable String name, @PathVariable String surname) throws IOException {

        return customerService.findCustomerByName(name, surname);
    }
    @PostMapping("/new")
    @ResponseBody
    public List<Customer> createNewCustomer(@RequestBody Customer Customer) throws IOException {

        Customer newCustomer = new Customer(Customer.getName(), Customer.getSurname());
        return customerService.addNewCustomer(newCustomer);
    }

}
