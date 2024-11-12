package com.example.ShoeFactory.repository;

import com.example.ShoeFactory.entity.ShoeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends CrudRepository<ShoeEntity, Integer> {
}
