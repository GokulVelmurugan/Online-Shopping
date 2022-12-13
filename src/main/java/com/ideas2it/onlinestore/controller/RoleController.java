package com.ideas2it.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.onlinestore.model.Role;
import com.ideas2it.onlinestore.service.RoleService;
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        roleService.createRole(role);
        return new ResponseEntity<>("Role is Successfully Deleted", HttpStatus.OK);
    }

    @PutMapping("/updateRole")
    public ResponseEntity<String> updateRoleDetails(@RequestBody Role role) {
        if (roleService.updateRole(role)) {
            return new ResponseEntity<>("Role is Successfully Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid Role Id", HttpStatus.BAD_REQUEST);
    }
}
