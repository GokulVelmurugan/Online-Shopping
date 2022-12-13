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

import com.ideas2it.onlinestore.model.Cart;
import com.ideas2it.onlinestore.service.CartService;

@RestController
//@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/cart")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
		
		Cart c = this.cartService.createCart(cart);		
		return new ResponseEntity<>(c, HttpStatus.CREATED);		
	}
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<Cart> getCartBYId(@PathVariable("cartId") Integer id) {
		
		return new ResponseEntity<>(this.cartService.getCartById(id), HttpStatus.FOUND);
	}
	
	@PutMapping("/cart")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
		return new ResponseEntity<>(this.cartService.updateCart(cart), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("cart/{cartId}") 
	public ResponseEntity<Void> deleteCart(@PathVariable("cartId") Integer id) {
		return new ResponseEntity<>(HttpStatus.GONE);
	}
}
