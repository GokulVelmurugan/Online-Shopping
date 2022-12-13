package com.ideas2it.onlinestore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.onlinestore.model.Inventory;
import com.ideas2it.onlinestore.service.InventoryService;

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
	public List<Inventory> getInventoryProducts() {
		return inventoryService.getInventoryProducts();
	}
	
	/**
	 * This method is used to delete the inventory product 
	 * which is damaged
	 * 
	 * @return list of inventory products
	 */
	@DeleteMapping("/{id}")
	public boolean deleteInventoryProduct(@PathVariable int id) {
		return true;
	}
}
