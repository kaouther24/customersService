package com.bank.customer.service;

import com.bank.customer.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final ResourceLoader resourceLoader;
    private static List<Customer> customers;

    public CustomerService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    // Loads the customers from the JSON file
    public List<Customer> getCustomers() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:Customers.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Customer>>() {
        });
    }

    public List<Customer> findCustomerByName(String name, String surname) throws IOException {
        if (customers == null) {
            customers = getCustomers();
        }
        return customers.stream().filter(customer -> customer.getName().equalsIgnoreCase(name) && customer.getSurname().equalsIgnoreCase(surname)).collect(Collectors.toList());
    }

    public Optional<Customer> findCustomerByUuid(String uuid) throws IOException {
        if (customers == null) {
            customers = getCustomers();
        }
        return customers.stream().filter(customer -> customer.getUuid().equalsIgnoreCase(uuid)).findFirst();
    }


    public List<Customer> addNewCustomer(Customer newCustomer) throws IOException {
        if (customers == null) {
            customers = getCustomers();
        }
        customers.add(newCustomer);
        return customers;
    }

}
