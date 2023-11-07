package com.ecommerce.app.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
  private CustomerService customerService;

   @GetMapping({"/",""})
    List<Customer>findAllCustomers(){
        return customerService.findAll();
    }





}
