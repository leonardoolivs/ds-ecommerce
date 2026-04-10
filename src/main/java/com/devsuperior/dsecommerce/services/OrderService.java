package com.devsuperior.dsecommerce.services;

import com.devsuperior.dsecommerce.dtos.OrderDTO;
import com.devsuperior.dsecommerce.dtos.OrderProductDTO;
import com.devsuperior.dsecommerce.exceptions.ResourceNotFoundException;
import com.devsuperior.dsecommerce.models.Order;
import com.devsuperior.dsecommerce.models.OrderProduct;
import com.devsuperior.dsecommerce.models.Product;
import com.devsuperior.dsecommerce.models.User;
import com.devsuperior.dsecommerce.repositories.OrderProductRepository;
import com.devsuperior.dsecommerce.repositories.OrderRepository;
import com.devsuperior.dsecommerce.repositories.ProductRepository;
import com.devsuperior.dsecommerce.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ID not found"));

        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO){
        Order order = new Order();
        User user = userService.authenticated();

        order.setUser(user);

        for(OrderProductDTO orderProductDTO : orderDTO.getOrderProducts()){
            Product product = productRepository.getReferenceById(orderProductDTO.getProductId());
            OrderProduct orderProduct = new OrderProduct(order, product, orderProductDTO.getQuantity(), product.getPrice());
            order.getOrderProducts().add(orderProduct);
        }

        orderRepository.save(order);
        orderProductRepository.saveAll(order.getOrderProducts());

        return new OrderDTO(order);
    }
}