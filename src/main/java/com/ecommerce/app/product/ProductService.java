package com.ecommerce.app.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    List<Product> findAll(){
        return repository.findAll();
    }
    Optional<Product> findById(Long id){
        return repository.findById(id);
    }
   Product save(Product product){
        return repository.save(product);
   }
   void deleteById(Long id){
        repository.deleteById(id);
   }


    public Product updateProduct(Product newProduct, Long productId) {
        Optional<Product> product = repository.findById(productId);
       return product.map(oldProduct->{
         oldProduct.setName(newProduct.getName());
         oldProduct.setDescription(newProduct.getDescription());
         return repository.save(oldProduct);
        }).orElseGet(()->{
            newProduct.setId(productId);
            return repository.save(newProduct);
        });
    }
}
