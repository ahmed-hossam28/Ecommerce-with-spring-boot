package com.ecommerce.app.order;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    List<OrderX> findAllOrders(){
        return orderRepository.findAll();
    }
   OrderX save(OrderX order){
       return  orderRepository.save(order);
    }
   Optional<OrderX> findById(Long id){
        return orderRepository.findById(id);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
