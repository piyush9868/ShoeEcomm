package com.example.ShoeFactory.service;

import com.example.ShoeFactory.entity.OrderEntity;
import com.example.ShoeFactory.entity.ShoeEntity;
import com.example.ShoeFactory.model.Order;
import com.example.ShoeFactory.repository.OrderRepository;
import org.apache.commons.logging.Log;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderEntity registerOrder(Order order) throws Exception {
        OrderEntity orderEntity = order.convertModelToEntity();
        return orderRepository.save(orderEntity);
    }
}
