package com.example.ShoeFactory.repository;

import com.example.ShoeFactory.entity.ShoeEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShoeRepository extends CrudRepository<ShoeEntity, Integer> {
}
