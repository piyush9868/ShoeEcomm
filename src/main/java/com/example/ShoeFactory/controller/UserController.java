package com.example.ShoeFactory.controller;


import com.example.ShoeFactory.model.User;
import com.example.ShoeFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /*
    Provide first name, last name, email and password to complete the sign-up
     */
    @PostMapping(value = "/sign-up", consumes = "application/json")
    public ResponseEntity<?> signUp(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.createNewUser(user));
    }

    @GetMapping("/getUserByEmail")
    public ResponseEntity<?> getUserByEmailId(@RequestParam String emailId){
        try {
            User user = userService.getUserByEmailId(emailId);
            if(user == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user with the given email ID.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DataBase error");
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
