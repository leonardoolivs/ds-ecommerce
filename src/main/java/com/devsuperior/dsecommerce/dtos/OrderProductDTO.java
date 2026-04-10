package com.devsuperior.dsecommerce.dtos;

import com.devsuperior.dsecommerce.models.OrderProduct;

public class OrderProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;

    public OrderProductDTO() {
    }

    public OrderProductDTO(Long id, String name, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderProductDTO(OrderProduct orderProduct) {
        id = orderProduct.getProduct().getId();
        name = orderProduct.getProduct().getName();
        price = orderProduct.getPrice();
        quantity = orderProduct.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal() {
        return quantity * price;
    }
}
