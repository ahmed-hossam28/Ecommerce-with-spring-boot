package com.ecommerce.app.customer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    private final CustomerRepository repository;
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Optional<Customer> findCustomerById(Long id){
       return repository.findById(id);
    }
    public Customer addCustomer(Customer customer){
        return repository.save(customer);
    }
    public void removeById(Long id){
        repository.deleteById(id);
    }

}
