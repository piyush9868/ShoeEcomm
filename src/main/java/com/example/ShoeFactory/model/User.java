package com.example.ShoeFactory.model;

import com.example.ShoeFactory.entity.AddressEntity;
import com.example.ShoeFactory.entity.OrderEntity;

import java.util.List;

public class User {

    int userId;

    String firstName;

    String lastName;

    String emailId;
    String password;

    List<AddressEntity> allAddresses;

    List<OrderEntity> allOrders;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AddressEntity> getAllAddresses() {
        return allAddresses;
    }

    public void setAllAddresses(List<AddressEntity> allAddresses) {
        this.allAddresses = allAddresses;
    }

    public List<OrderEntity> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(List<OrderEntity> allOrders) {
        this.allOrders = allOrders;
    }
}
