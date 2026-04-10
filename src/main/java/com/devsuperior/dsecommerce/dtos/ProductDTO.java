package com.devsuperior.dsecommerce.dtos;

import com.devsuperior.dsecommerce.models.Category;
import com.devsuperior.dsecommerce.models.Product;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 80)
    private String name;

    @NotBlank
    @Size(min = 10)
    private String description;
    @Positive
    private Double price;
    private String imgUrl;

    @NotEmpty
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.imgUrl = entity.getImgUrl();
        for(Category category : entity.getCategories()){
            categories.add(new CategoryDTO(category));
        }
    }

    public Product toDtoEntity() {
        Product entity = new Product();
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setPrice(this.price);
        entity.setImgUrl(this.imgUrl);
        for(CategoryDTO category : categories){
            Category cat = new Category();
            cat.setId(category.getId());
            entity.getCategories().add(cat);
        }
        return entity;
    }

    public void copyDtoToEntity(Product entity) {
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setPrice(this.price);
        entity.setImgUrl(this.imgUrl);

        entity.getCategories().clear();

        for(CategoryDTO category : categories){
            Category cat = new Category();
            cat.setId(category.getId());
            entity.getCategories().add(cat);
        }
    }

    public ProductDTO(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}