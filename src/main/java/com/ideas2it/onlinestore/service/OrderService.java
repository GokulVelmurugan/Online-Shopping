package com.ideas2it.onlinestore.service;

import com.ideas2it.onlinestore.model.OrderList;

public interface OrderService {
	
	public OrderList createOrder(OrderList order);
	
	public OrderList getOrderById(int orderId);
	
	public OrderList updateOrder(OrderList order);
	
	public void deleteOrder(int orderId);

}
