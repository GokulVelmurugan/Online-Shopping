package com.ideas2it.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.onlinestore.model.Address;
import com.ideas2it.onlinestore.service.AddressService;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/createAddress")
    public ResponseEntity<String> createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
        return new ResponseEntity<>("Address is Created Successfully", HttpStatus.OK);
    }

    @GetMapping("/viewAddress/{id}")
    public ResponseEntity<Object> viewAddressDetails(@PathVariable("id") int id) {
        if (addressService.isAddressExist(id)) {
            Address address = addressService.viewAddressDetails(id);
            return new ResponseEntity<>(address, HttpStatus.OK);
        } else {
            System.out.println("Exception");
            return new ResponseEntity<>("Invalid Address Id", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<String> updateAddressDetails(@RequestBody Address address) {
        if (addressService.isAddressExist(address.getId())) {
            if (addressService.updateAddressDetails(address)) {
                return new ResponseEntity<>("Address is Successfully Updated", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid Address Id", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") int id) {
        if (addressService.isAddressExist(id)) {
            if (addressService.deleteAddress(id)) {
                return new ResponseEntity<>("Address is Successfully Deleted", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid Address Id", HttpStatus.BAD_REQUEST);
    }
}
