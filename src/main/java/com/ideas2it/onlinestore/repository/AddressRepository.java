package com.ideas2it.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.onlinestore.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
