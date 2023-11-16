package com.ecommerce.app.order;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderX{
    @Id
    Long id;
    Integer orderQuantity;
    Double price;
    public OrderX(){};

    public OrderX(Long id, Integer orderQuantity, Double price) {
        this.id = id;
        this.orderQuantity = orderQuantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "OrderX{" +
                "id=" + id +
                ", orderQuantity=" + orderQuantity +
                ", price=" + price +
                '}';
    }
}
