package com.example.ShoeFactory.service.impl;

import com.example.ShoeFactory.entity.ShoeEntity;
import com.example.ShoeFactory.model.Shoe;
import com.example.ShoeFactory.repository.ShoeRepository;
import com.example.ShoeFactory.service.ShoeOpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoeOpsServiceImpl implements ShoeOpsService {

    @Autowired
    private ShoeRepository shoeRepository;

    public ResponseEntity<?> saveNewShoe(Shoe shoe) {
        try {
            ShoeEntity shoeEntity = new ShoeEntity();
            shoeEntity.setName(shoe.getName());
            shoeEntity.setPrice(shoe.getPrice());
            ShoeEntity savedEntity = shoeRepository.save(shoeEntity);
            return ResponseEntity.ok(savedEntity);
        }
        catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DataBase error");
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ShoeEntity findShoeById(Integer shoeId) throws Exception {
        Optional<ShoeEntity> optionalShoeEntity = shoeRepository.findById(shoeId);
        if(optionalShoeEntity.isPresent()){
            return optionalShoeEntity.get();
        }
        return null;
    }

    public ResponseEntity<?> findAll() {
        try {
            Iterable<ShoeEntity> shoeEntityIterable = shoeRepository.findAll();
            List<ShoeEntity> result = new ArrayList<>();
            shoeEntityIterable.forEach(result::add);
            if(!result.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DataBase error");
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
