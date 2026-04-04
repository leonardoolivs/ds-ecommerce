package com.devsuperior.dsecommerce.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ORDER_PRODUCT")
public class OrderProduct {

    @EmbeddedId
    private OrderProductPKs id = new OrderProductPKs();

    private Integer quantity;
    private Double price;

    public OrderProduct(Order order, Product product, Integer quantity, Double price) {
        this.id.setProduct(product);
        this.id.setOrder(order);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderProduct(){}

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
