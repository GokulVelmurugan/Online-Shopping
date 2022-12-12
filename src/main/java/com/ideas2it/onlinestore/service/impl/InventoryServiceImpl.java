package com.ideas2it.onlinestore.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.onlinestore.model.Inventory;
import com.ideas2it.onlinestore.repository.InventoryRepository;
import com.ideas2it.onlinestore.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public Inventory addQuantity(String productName) {
		Inventory inventory = inventoryRepository.findByProductName(productName);
		if (null == inventory) {
			inventory = new Inventory();
			inventory.setProductName(productName);
		} 
		inventory.setQuantity(inventory.getQuantity() + 1);
		return inventoryRepository.save(inventory);
	}

	@Override
	public List<Inventory> getInventoryProducts() {
		List<Inventory> inventoryProducts = inventoryRepository.findAll();
		if (null != inventoryProducts && !inventoryProducts.isEmpty()) {
			List<Inventory> filterInventoryProducts = new CopyOnWriteArrayList<>();
			filterInventoryProducts.addAll(inventoryProducts);
			for (Inventory inventory: filterInventoryProducts) {
				if (inventory.isStatus() || 0 == inventory.getQuantity()) {
					filterInventoryProducts.remove(inventory);
				}
			}
			if (filterInventoryProducts.isEmpty()) {
				System.out.println("throw exception");
			}
			return filterInventoryProducts;
		} else {
			System.out.println("throw exception");
		}
		return null;
	}

	@Override
	public boolean decreaseQuantity(String productName) {
		Inventory inventory = inventoryRepository.findByProductName(productName);
		if (null == inventory) {
			inventory = new Inventory();
			inventory.setProductName(productName);
		} 
		inventory.setQuantity(inventory.getQuantity() - 1);
		return inventoryRepository.save(inventory).equals(inventory);
	}

	@Override
	public boolean deleteInventoryProducts(int id) {
		Inventory inventory = inventoryRepository.findById(id).orElse(null);
		if (null != inventory) {
			inventory.setStatus(true);
			return inventoryRepository.save(inventory).equals(inventory);
		}
		return false;
	}
}
