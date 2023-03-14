package com.hotel.controller;

import com.hotel.models.Users;
import com.hotel.service.UserService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{usernameOrEmail}")
    public Users getUserByUsernameOrEmail(@PathVariable(name = "usernameOrEmail") String usernameOrEmail) {

        return userService.getUserByUsernameOrEmail(usernameOrEmail);
    }

    @DeleteMapping("/{usernameOrEmail}")
    public void deleteUserByUsernameOrEmail(@PathVariable(name = "usernameOrEmail") String usernameOrEmail) {

        userService.deleteUserByUsernameOrEmail(usernameOrEmail);
    }
}
