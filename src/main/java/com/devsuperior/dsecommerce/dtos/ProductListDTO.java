package com.devsuperior.dsecommerce.dtos;

import com.devsuperior.dsecommerce.models.Product;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductListDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 80)
    private String name;

    @NotBlank

    @Positive
    private Double price;
    private String imgUrl;

    public ProductListDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.imgUrl = entity.getImgUrl();
    }

    public Product toEntity() {
        Product entity = new Product();
        entity.setName(this.name);
        entity.setPrice(this.price);
        entity.setImgUrl(this.imgUrl);
        return entity;
    }

    public void copyToEntity(Product entity) {
        entity.setName(this.name);
        entity.setPrice(this.price);
        entity.setImgUrl(this.imgUrl);
    }

    public ProductListDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}