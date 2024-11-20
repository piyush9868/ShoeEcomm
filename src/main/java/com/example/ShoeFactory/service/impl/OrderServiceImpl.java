package com.example.ShoeFactory.service.impl;

import com.example.ShoeFactory.entity.OrderEntity;
import com.example.ShoeFactory.model.Order;
import com.example.ShoeFactory.repository.OrderRepository;
import com.example.ShoeFactory.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderEntity registerOrder(Order order) throws Exception {
        OrderEntity orderEntity = order.convertModelToEntity();
        return orderRepository.save(orderEntity);
    }
}
