package com.example.ShoeFactory.service.impl;

import com.example.ShoeFactory.entity.UserEntity;
import com.example.ShoeFactory.model.User;
import com.example.ShoeFactory.repository.UserRepository;
import com.example.ShoeFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User createNewUser(User user){
        return new User();
    }

    public User getUserByEmailId(String emailId) {
        UserEntity userEntity = userRepository.findByEmailAddress(emailId);
        return userEntity.mapToUser();
    }
}