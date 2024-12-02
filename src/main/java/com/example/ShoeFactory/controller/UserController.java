package com.example.ShoeFactory.controller;

import com.example.ShoeFactory.model.LoginDetails;
import com.example.ShoeFactory.model.User;
import com.example.ShoeFactory.security.JWTTokenProvider;
import com.example.ShoeFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    @Lazy
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        userService.createNewUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDetails loginDetails) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDetails.getUsername(), loginDetails.getPassword())
            );
            String token = jwtTokenProvider.generateToken(authentication.getName(), "ROLE_"+loginDetails.getRole());
            return ResponseEntity.ok(token);
        } catch (UsernameNotFoundException usernameNotFoundException) {
            return ResponseEntity.status(401).body(usernameNotFoundException.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid Password");
        }
    }
}

