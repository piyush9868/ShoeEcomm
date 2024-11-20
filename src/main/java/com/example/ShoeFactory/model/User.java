package com.example.ShoeFactory.model;

import com.example.ShoeFactory.entity.AddressEntity;
import com.example.ShoeFactory.entity.OrderEntity;
import lombok.Data;

import java.util.List;

@Data
public class User {
    int userId;
    String firstName;
    String lastName;
    String emailId;
    String password;
    List<AddressEntity> allAddresses;
    List<OrderEntity> allOrders;
}
