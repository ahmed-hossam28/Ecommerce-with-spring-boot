package com.ecommerce.app.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/",""})
   ResponseEntity<List<Customer>> findAllCustomers(){
        List<Customer>result = customerService.findAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId){
        Optional<Customer> customer = customerService.findCustomerById(customerId);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
            Customer customer1 = customerService.addCustomer(customer);
      return new ResponseEntity<>(customer1,HttpStatus.CREATED);
    }


   @DeleteMapping("/{customerId}")
    ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId){
         customerService.removeById(customerId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   @PutMapping("/{customerId}")
   ResponseEntity<Customer> updateCustomer(@RequestBody Customer newCustomer,@PathVariable Long customerId){
        Customer customer = customerService.updateCustomer(newCustomer,customerId);
        return new ResponseEntity<>(customer,HttpStatus.OK);
   }

}
