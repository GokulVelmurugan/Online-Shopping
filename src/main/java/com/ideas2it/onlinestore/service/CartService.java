package com.ideas2it.onlinestore.service;

import com.ideas2it.onlinestore.model.Cart;

public interface CartService {
	
	public Cart createCart(Cart cart);
	
	public Cart getCartById(int cartId);
	
	public Cart updateCart(Cart cart);
	
	public void deleteCart(int cartId);

}
