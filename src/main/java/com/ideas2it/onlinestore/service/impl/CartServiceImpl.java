package com.ideas2it.onlinestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ideas2it.onlinestore.model.Cart;
import com.ideas2it.onlinestore.repository.CartRepository;
import com.ideas2it.onlinestore.service.CartService;
import com.ideas2it.onlinestore.util.customException.OnlineStoreException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Cart createCart(Cart cart) {
		return this.cartRepository.save(cart);
	}

	@Override
	public Cart getCartById(int cartId) {
		return this.cartRepository.findById(cartId)
				.orElseThrow(()-> new OnlineStoreException("Cart not found. ID: " +cartId, HttpStatus.NOT_FOUND));
	}

	@Override
	public Cart updateCart(Cart cart) {
		return this.cartRepository.save(cart);
		
	}

	@Override
	public void deleteCart(int cartId) {
		this.cartRepository.deleteById(cartId);		
	}

	
}
