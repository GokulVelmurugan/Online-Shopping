package com.ideas2it.onlinestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.onlinestore.model.Inventory;
import com.ideas2it.onlinestore.service.InventoryService;
import com.ideas2it.onlinestore.util.customException.OnlineStoreException;

/**
 * The Inventory controller class that implements an application that Simply
 * read, delete these operations called from service
 * to controller class
 *
 * @version 1.0
 * @author arunkumar
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	/**
	 * This method is used to get list of inventory products
	 * 
	 * @return list of inventory products
	 */
	@GetMapping()
	public ResponseEntity<List<Inventory>> getInventoryProducts() {
		List<Inventory> inventoryProducts = null;
		try {
			inventoryProducts = inventoryService.getInventoryProducts();
		} catch (OnlineStoreException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(inventoryProducts, HttpStatus.OK);
	}
	
	/**
	 * This method is used to get the inventory product 
	 * by using inventory id
	 * 
	 * @param id
	 * @return inventory product as a response entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Inventory> getInventoryProduct(@PathVariable int id) {
		Inventory inventoryProduct = null;
		try {
			inventoryProduct = inventoryService.getInventoryProductById(id);
		} catch (OnlineStoreException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(inventoryProduct, HttpStatus.OK);
	}
	
	/**
	 * This method is used to delete the inventory product 
	 * which is damaged
	 * 
	 * @return list of inventory products
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteInventoryProduct(@PathVariable int id) {
		boolean status = false;
		try {
			status = inventoryService.deleteInventoryProducts(id);
		} catch (OnlineStoreException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
