package com.example.ShoeFactory.controller;

import com.example.ShoeFactory.entity.OrderEntity;
import com.example.ShoeFactory.model.Order;
import com.example.ShoeFactory.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/register-order")
    public ResponseEntity<?> orderShoes(@RequestBody Order order ) {
        try {
            OrderEntity orderEntity = orderService.registerOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body(orderEntity);
        }
        catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DataBase error");
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
