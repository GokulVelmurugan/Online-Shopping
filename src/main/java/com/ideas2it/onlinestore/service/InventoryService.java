package com.ideas2it.onlinestore.service;

import java.util.List;

import com.ideas2it.onlinestore.model.Inventory;
import com.ideas2it.onlinestore.util.customException.OnlineStoreException;

/**
 * This interface handles read, add quantity, add quantity, and delete operation 
 * for inventory model
 *
 * @version 1.0
 * @author arunkumar
 */
public interface InventoryService {

	/**
	 * This method is used to add the quantity of product if is exist
	 * else it's create new object 
	 * 
	 * @param productName
	 * @return Inventory object
	 */
	public Inventory addQuantity(String productName);
	
	/**
	 * This method is used to get the inventory products
	 * 
	 * @return Inventory products
	 * @throws OnlineStoreException
	 */
	public List<Inventory> getInventoryProducts() throws OnlineStoreException;
	
	/**
	 * This method is used to get the inventory product by id
	 * 
	 * @return Inventory product
	 * @throws OnlineStoreException
	 */
	public Inventory getInventoryProductById(int id) throws OnlineStoreException;
	
	/**
	 * If quantity will decrease then return true 
	 * else it return false
	 * 
	 * @param productName
	 * @return true/false
	 * @throws OnlineStoreException
	 */
	public boolean decreaseQuantity(String productName) throws OnlineStoreException; 
	
	/**
	 * This method return true if the given id product will deleted
	 * else return false
	 * 
	 * @param id
	 * @return true/false
	 * @throws OnlineStoreException 
	 */
	public boolean deleteInventoryProducts(int id) throws OnlineStoreException; 
}
