package com.example.ShoeFactory.controller;

import com.example.ShoeFactory.entity.ShoeEntity;
import com.example.ShoeFactory.model.Shoe;
import com.example.ShoeFactory.service.ShoeOpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ShoeController {

    @Autowired
    ShoeOpsService shoeOpsService;

    @PostMapping("/save")
    public ResponseEntity<?> saveShoe(@RequestParam String name, @RequestParam int price) {
        Shoe shoe = new Shoe();
        shoe.setName(name);
        shoe.setPrice(price);
        return shoeOpsService.saveNewShoe(shoe);
    }

    @GetMapping("/get/{shoeId}")
    public ResponseEntity<?> getShoe(@PathVariable Integer shoeId){
        try {
            ShoeEntity shoeEntity = shoeOpsService.findShoeById(shoeId);
            if(shoeEntity != null){
                return ResponseEntity.status(HttpStatus.OK).body(shoeEntity);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DataBase error");
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllShoes(){
        return shoeOpsService.findAll();
    }
}