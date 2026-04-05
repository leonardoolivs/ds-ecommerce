package com.devsuperior.dsecommerce.services;

import com.devsuperior.dsecommerce.dtos.ProductDTO;
import com.devsuperior.dsecommerce.models.Product;
import com.devsuperior.dsecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> product = productRepository.findById(id);

        return new ProductDTO(product.get());
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){

        Page<Product> listProduct = productRepository.findAll(pageable);

        return listProduct.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO){
        Product product = productDTO.toEntity();

        productRepository.save(product);

        return new ProductDTO(product);
    }

}
