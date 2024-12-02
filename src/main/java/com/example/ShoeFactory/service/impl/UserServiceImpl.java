package com.example.ShoeFactory.service.impl;

import com.example.ShoeFactory.entity.UserEntity;
import com.example.ShoeFactory.model.User;
import com.example.ShoeFactory.repository.UserRepository;
import com.example.ShoeFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createNewUser(User user){
        if (userRepository.findByEmailAddress(user.getEmailId()) != null) {
            throw new IllegalArgumentException("User already exists");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setEmailId(user.getEmailId());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setRole("ROLE_" + user.getRole());
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmailAddress(emailId);
        if(user == null)
            throw new UsernameNotFoundException("User Not found with the given emailId");

        return new org.springframework.security.core.userdetails.User(
                user.getEmailId(),
                user.getPassword(),
                Collections.singletonList(new org.springframework.security.core.authority.SimpleGrantedAuthority(user.getRole()))
        );
    }
}
