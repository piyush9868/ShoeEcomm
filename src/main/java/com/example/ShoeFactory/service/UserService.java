package com.example.ShoeFactory.service;

import com.example.ShoeFactory.model.User;

public interface UserService {
    User createNewUser(User user);

    User getUserByEmailId(String emailId);
}
