package com.bank.customer.controller;

import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTests {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer mockCustomer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a mock customer object for testing
        mockCustomer = new Customer("John", "Doe");
        mockCustomer.setUuid("123");
    }

    @Test
    void healthCheck() {
        ResponseEntity<String> response = customerController.healthCheck();
        assertNotNull(response);
        assertEquals("Application is healthy", response.getBody());
    }

    @Test
    void getCustomerByUuid() throws IOException {
        // Arrange
        when(customerService.findCustomerByUuid("123")).thenReturn(Optional.of(mockCustomer));

        // Act
        Optional<Customer> result = customerController.getCustomerByUuid("123");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("John", result.get().getName());
        verify(customerService, times(1)).findCustomerByUuid("123");
    }

    @Test
    void getCustomerByName() throws IOException {
        // Arrange
        List<Customer> mockCustomers = Arrays.asList(mockCustomer);
        when(customerService.findCustomerByName("John", "Doe")).thenReturn(mockCustomers);

        // Act
        List<Customer> result = customerController.getCustomerByName("John", "Doe");

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Doe", result.get(0).getSurname());
        verify(customerService, times(1)).findCustomerByName("John", "Doe");
    }

    @Test
    void createNewCustomer() throws IOException {
        // Arrange
        Customer newCustomer = new Customer("Jane", "Doe");
        List<Customer> mockCustomers = Arrays.asList(newCustomer);
        when(customerService.addNewCustomer(any(Customer.class))).thenReturn(mockCustomers);

        // Act
        List<Customer> result = customerController.createNewCustomer(newCustomer);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Jane", result.get(0).getName());
        verify(customerService, times(1)).addNewCustomer(any(Customer.class));
    }

}
