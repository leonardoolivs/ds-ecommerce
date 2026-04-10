package com.devsuperior.dsecommerce.dtos;

import com.devsuperior.dsecommerce.models.OrderProduct;
import org.aspectj.weaver.ast.Or;

public class OrderProductDTO {

    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;
    private String imgUrl;

    public OrderProductDTO() {
    }

    public OrderProductDTO(OrderProduct orderProduct) {
        productId = orderProduct.getProduct().getId();
        name = orderProduct.getProduct().getName();
        price = orderProduct.getPrice();
        quantity = orderProduct.getQuantity();
        imgUrl = orderProduct.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getSubTotal() {
        return quantity * price;
    }
}
