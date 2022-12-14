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

import com.ideas2it.onlinestore.model.OrderList;
import com.ideas2it.onlinestore.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<OrderList> addOrder(@RequestBody OrderList order) {
		
		OrderList c = this.orderService.createOrder(order);		
		return new ResponseEntity<>(c, HttpStatus.CREATED);		
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<OrderList> getOrderBYId(@PathVariable("orderId") Integer id) {
		
		return new ResponseEntity<>(this.orderService.getOrderById(id), HttpStatus.FOUND);
	}
	
	@PutMapping("/order")
	public ResponseEntity<OrderList> updateOrder(@RequestBody OrderList order) {
		return new ResponseEntity<>(this.orderService.updateOrder(order), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("order/{orderId}") 
	public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Integer id) {
		return new ResponseEntity<>(HttpStatus.GONE);
	}
}
