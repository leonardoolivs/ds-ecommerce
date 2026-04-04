package com.devsuperior.dsecommerce.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "TB_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Instant moment;
    public OrderStatus orderStatus;

    public User user;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User user) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
