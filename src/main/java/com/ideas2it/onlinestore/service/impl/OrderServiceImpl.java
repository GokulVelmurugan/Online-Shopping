package com.ideas2it.onlinestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ideas2it.onlinestore.model.OrderList;
import com.ideas2it.onlinestore.repository.OrderRepository;
import com.ideas2it.onlinestore.service.OrderService;
import com.ideas2it.onlinestore.util.customException.OnlineStoreException;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public OrderList createOrder(OrderList order) {
		return this.orderRepository.save(order);
	}

	@Override
	public OrderList getOrderById(int orderId) {
		return this.orderRepository.findById(orderId)
				.orElseThrow(()-> new OnlineStoreException("Order not found. ID: " +orderId, HttpStatus.NO_CONTENT));
	}

	@Override
	public OrderList updateOrder(OrderList order) {
		// TODO Auto-generated method stub
		return this.orderRepository.save(order);
	}

	@Override
	public void deleteOrder(int orderId) {
		this.orderRepository.deleteById(orderId);
		
	}

	
}
