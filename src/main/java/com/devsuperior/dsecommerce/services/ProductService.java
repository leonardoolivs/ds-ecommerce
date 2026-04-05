package com.devsuperior.dsecommerce.services;

import com.devsuperior.dsecommerce.dtos.ProductDTO;
import com.devsuperior.dsecommerce.models.Product;
import com.devsuperior.dsecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductDTO findById(Long id){
        Optional<Product> product = productRepository.findById(id);

        return new ProductDTO(product.get());
    }

    public Page<ProductDTO> findAll(Pageable pageable){

        Page<Product> listProduct = productRepository.findAll(pageable);

        return listProduct.map(x -> new ProductDTO(x));
    }

}
