package com.ecommerce.app.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/",""})
    List<Customer>findAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/{customerId}")
    Customer getCustomerById(@PathVariable Long customerId){
      return customerService.findCustomerById(customerId).orElseThrow(RuntimeException::new);
    }


    @PostMapping
    Customer addCustomer(@RequestBody Customer customer){
      return customerService.addCustomer(customer);
    }


   @DeleteMapping("/{customerId}")
    void deleteCustomer(@PathVariable Long customerId){
       customerService.removeById(customerId);
   }


}
