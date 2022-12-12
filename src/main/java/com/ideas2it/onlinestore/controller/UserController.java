package com.ideas2it.onlinestore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.onlinestore.model.User;

@RestController
public class UserController {
    /*@PostMapping("/createUser")
    public RequestEntity<String> createUser(@RequestBody User user) {
        user = userService.createUser(user);
        return new ResponseEntity<>("Profile is successfully created and Id is " + user.getId()),HttpStatus.CREATED);
    }*/
}
