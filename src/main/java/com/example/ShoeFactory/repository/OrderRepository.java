package com.example.ShoeFactory.repository;

import com.example.ShoeFactory.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
}
