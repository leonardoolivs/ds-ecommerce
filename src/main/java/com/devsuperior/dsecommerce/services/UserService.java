package com.devsuperior.dsecommerce.services;

import com.devsuperior.dsecommerce.dtos.UserDTO;
import com.devsuperior.dsecommerce.models.Role;
import com.devsuperior.dsecommerce.models.User;
import com.devsuperior.dsecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDTO> result = userRepository.searchUserAndRolesByEmail(username);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());
        for(UserDTO userDTO : result){
            user.addRole(new Role(userDTO.getRoleId(), userDTO.getAuthority()));
        }

        return user;
    }
}
