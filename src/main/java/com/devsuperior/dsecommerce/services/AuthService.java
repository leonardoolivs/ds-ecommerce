package com.devsuperior.dsecommerce.services;

import com.devsuperior.dsecommerce.exceptions.ForbiddenException;
import com.devsuperior.dsecommerce.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long userId) {
        User user = userService.authenticated();
        if (!user.hasRole("ROLE_ADMIN") && !user.getId().equals(userId)){
            throw new ForbiddenException("Access denied");
        }
    }
}
