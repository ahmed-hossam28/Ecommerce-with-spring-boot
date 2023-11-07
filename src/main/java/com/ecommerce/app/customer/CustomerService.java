package com.ecommerce.app.customer;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
   private CustomerRepository repository;
    public List<Customer> findAll() {
        return repository.findAll();
    }
}
