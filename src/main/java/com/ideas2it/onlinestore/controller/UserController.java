package com.ideas2it.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ideas2it.onlinestore.model.User;
import com.ideas2it.onlinestore.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        user = userService.createUser(user);
        return new ResponseEntity<>("Profile is successfully created and Id is " + user.getId(),HttpStatus.CREATED);
    }

    @GetMapping("/viewUser/{id}")
    public ResponseEntity<Object> viewUserDetails(@PathVariable("id") int id) {
        if (userService.isUserExist(id)) {
            User user = userService.viewUserDetails(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            System.out.println("Exception");
            return new ResponseEntity<>("Invalid User Id", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUserDetails(@RequestBody User user) {
        if (userService.isUserExist(user.getId())) {
            if (userService.updateUserDetails(user)) {
                return new ResponseEntity<>("User Profile is Successfully Updated", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid User Id", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable("id") int id) {
        if (userService.isUserExist(id)) {
            if (userService.deleteUser(id)) {
                return new ResponseEntity<>("Profile is Successfully Deleted", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid User Id", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/viewAllUser")
    public ResponseEntity<List<User>> viewAllUserDetails() {
        List<User> users = userService.viewAllUserDetails();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
