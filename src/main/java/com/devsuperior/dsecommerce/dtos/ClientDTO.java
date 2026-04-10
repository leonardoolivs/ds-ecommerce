package com.devsuperior.dsecommerce.dtos;

import com.devsuperior.dsecommerce.models.User;

public class ClientDTO {

    private Long id;
    private String name;

    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User client){
        id = client.getId();
        name = client.getName();
    }

    public ClientDTO(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
