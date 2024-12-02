package com.example.ShoeFactory.service;

import com.example.ShoeFactory.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User createNewUser(User user);
}
