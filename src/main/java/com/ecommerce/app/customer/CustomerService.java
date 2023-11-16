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

    public List<com.ecommerce.app.customer.Customer> findAll() {
        return repository.findAll();
    }

    public Optional<com.ecommerce.app.customer.Customer> findCustomerById(Long id){
       return repository.findById(id);
    }
    public com.ecommerce.app.customer.Customer addCustomer(com.ecommerce.app.customer.Customer customer){
        return repository.save(customer);
    }
    public void removeById(Long id){
        repository.deleteById(id);
    }

    public Customer updateCustomer(Customer newCustomer, Long customerId) {
        Optional<Customer> customer = repository.findById(customerId);
        return customer.map(oldCustomer->{
            oldCustomer.setName(newCustomer.getName());
            oldCustomer.setEmail(newCustomer.getEmail());
            oldCustomer.setPassword(newCustomer.getPassword());
            return repository.save(oldCustomer);
        }).orElseGet(()->{
            newCustomer.setId(customerId);
            return repository.save(newCustomer);
        });
    }

}
