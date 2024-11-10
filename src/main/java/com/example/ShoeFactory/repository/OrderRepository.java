package com.example.ShoeFactory.repository;

import com.example.ShoeFactory.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
