package com.devsuperior.dsecommerce.dtos;

import com.devsuperior.dsecommerce.models.*;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientDTO user;
    private PaymentDTO payment;
    private Set<OrderProductDTO> orderProducts = new HashSet<>();

    public OrderDTO(Order entity){
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
        user = new ClientDTO(entity.getUser());
        payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
        for(OrderProduct orderProduct : entity.getOrderProducts()){
            orderProducts.add(new OrderProductDTO(orderProduct));
        }
    }

    public OrderDTO(){}

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getUser() {
        return user;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public Set<OrderProductDTO> getOrderProducts() {
        return orderProducts;
    }

    public Double getTotal(){
        double sum = 0.0;
        for(OrderProductDTO orderProductDTO : orderProducts){
            sum += orderProductDTO.getSubTotal();
        }

        return sum;
    }
}
