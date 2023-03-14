package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.Users;
import com.hotel.service.UserService;

@RestController
@RequestMapping("api/register")
public class RegisterUserController {

    @Autowired
    UserService userService;
    
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        userService.registerUser(user);
        return new ResponseEntity<>("Usuario registrado correctamente", HttpStatus.CREATED);
    }
}
