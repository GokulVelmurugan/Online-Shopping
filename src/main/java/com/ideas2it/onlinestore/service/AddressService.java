package com.ideas2it.onlinestore.service;

import com.ideas2it.onlinestore.model.Address;
public interface AddressService {
    void createAddress(Address address);
    Address viewAddressDetails(int id);
    boolean updateAddressDetails(Address address);
    boolean deleteAddress(int id);
    boolean isAddressExist(int id);
}
