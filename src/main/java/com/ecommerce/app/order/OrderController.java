package com.ecommerce.app.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController{
    OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    ResponseEntity<List<OrderX>> getOrders(){
        List<OrderX> AllOrders = orderService.findAllOrders();
        return new ResponseEntity<>(AllOrders, HttpStatus.OK);
   }

   @GetMapping("/{orderId}")
    ResponseEntity<OrderX> getOrder(@PathVariable Long orderId){
      Optional<OrderX> order =   orderService.findById(orderId);
       return order.map(value->new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }


    @PostMapping
    ResponseEntity<OrderX >addOrder(@RequestBody OrderX order){
        OrderX order1 = orderService.save(order);
       return  new ResponseEntity<>(order1,HttpStatus.CREATED) ;
   }

    @DeleteMapping("/{orderId}")
    ResponseEntity<Void> deleteOrder(@PathVariable Long orderId){
        orderService.delete(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }


}
