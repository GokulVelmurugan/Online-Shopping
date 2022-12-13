package com.ideas2it.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.onlinestore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
