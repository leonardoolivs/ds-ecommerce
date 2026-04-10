package com.devsuperior.dsecommerce.controllers;

import com.devsuperior.dsecommerce.dtos.OrderDTO;
import com.devsuperior.dsecommerce.services.OrderService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<OrderDTO> findById(@PathVariable("id") Long id){
        OrderDTO dto = orderService.findById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<OrderDTO> insert(@Valid @RequestBody OrderDTO orderDTO){
        orderDTO = orderService.insert(orderDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(orderDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(orderDTO);
    }
}
