package com.devsuperior.dsecommerce.dtos;

import com.devsuperior.dsecommerce.models.Payment;

import java.time.Instant;

public class PaymentDTO {

    private Long id;
    private Instant moment;

    public PaymentDTO(Payment entity){
        id = entity.getId();
        moment = entity.getMoment();
    }

    public PaymentDTO(){}

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }
}
