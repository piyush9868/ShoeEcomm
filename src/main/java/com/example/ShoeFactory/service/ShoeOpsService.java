package com.example.ShoeFactory.service;

import com.example.ShoeFactory.entity.ShoeEntity;
import com.example.ShoeFactory.model.Shoe;
import org.springframework.http.ResponseEntity;

public interface ShoeOpsService {
    ResponseEntity<?> saveNewShoe(Shoe shoe);

    ShoeEntity findShoeById(Integer shoeId) throws Exception;

    ResponseEntity<?> findAll();
}
