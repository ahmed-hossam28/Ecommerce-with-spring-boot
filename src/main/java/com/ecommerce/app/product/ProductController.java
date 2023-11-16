package com.ecommerce.app.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

     @GetMapping
     ResponseEntity<List<Product>> getProductList(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    ResponseEntity<Product>getProduct(@PathVariable Long productId){
        Optional<Product>product = productService.findById(productId);
        return product.map(productVal->new ResponseEntity<>(productVal,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    ResponseEntity<Product>addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    ResponseEntity<Product> update(@RequestBody Product newProduct, @PathVariable Long productId){
      Product product =  productService.updateProduct(newProduct,productId);
     return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @DeleteMapping("/{productId}")
    ResponseEntity<Void>updateProduct(@PathVariable Long productId){
          productService.deleteById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
