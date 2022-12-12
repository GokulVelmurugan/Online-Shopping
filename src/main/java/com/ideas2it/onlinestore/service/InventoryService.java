package com.ideas2it.onlinestore.service;

import java.util.List;

import com.ideas2it.onlinestore.model.Inventory;

public interface InventoryService {

	/**
	 * 
	 * @param productName
	 * @return Inventory object
	 */
	public Inventory addQuantity(String productName);
	
	/**
	 * 
	 * @return Inventory products
	 */
	public List<Inventory> getInventoryProducts();
	
	/**
	 * If quantity will decrease then return true 
	 * else it return false
	 * 
	 * @param productName
	 * @return true
	 */
	public boolean decreaseQuantity(String productName); 
}
