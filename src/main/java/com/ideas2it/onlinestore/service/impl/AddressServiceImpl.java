package com.ideas2it.onlinestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.onlinestore.model.Address;
import com.ideas2it.onlinestore.repository.AddressRepository;
import com.ideas2it.onlinestore.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address viewAddressDetails(int id) {
        Address address = addressRepository.getById(id);

        if (null != address || address.isStatus()) {
            System.out.println("Exception");
        }
        return address;
    }

    @Override
    public boolean updateAddressDetails(Address address) {
        boolean isUpdated = false;
        address = addressRepository.save(address);

        if (null != address) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAddress(int id) {
        Address address = viewAddressDetails(id);

        if (null != address) {
            address.setStatus(true);
            return addressRepository.save(address).equals(address);
        }
        return false;
    }

    @Override
    public boolean isAddressExist(int id) {
        return addressRepository.existsById(id);
    }
}
