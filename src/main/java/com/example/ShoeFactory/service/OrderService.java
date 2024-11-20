package com.example.ShoeFactory.service;

import com.example.ShoeFactory.entity.OrderEntity;
import com.example.ShoeFactory.model.Order;

public interface OrderService {
    OrderEntity registerOrder(Order order) throws Exception;
}
