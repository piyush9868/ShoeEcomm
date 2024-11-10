package com.example.ShoeFactory.service;

import com.example.ShoeFactory.entity.OrderEntity;
import com.example.ShoeFactory.entity.ShoeEntity;
import com.example.ShoeFactory.repository.OrderRepository;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShoeOpsService shoeOpsService;

    @Autowired
    OrderRepository orderRepository;

    public OrderEntity order(Integer shoeId) throws Exception{
        ShoeEntity shoeEntity = shoeOpsService.findShoeById(shoeId);
        if(shoeEntity == null){
            System.out.println("Can't find the required entity.");
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setShoeEntity(shoeEntity);
        return orderRepository.save(orderEntity);
    }
}
