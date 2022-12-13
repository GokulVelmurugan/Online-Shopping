package com.ideas2it.onlinestore.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.onlinestore.model.Inventory;
import com.ideas2it.onlinestore.repository.InventoryRepository;
import com.ideas2it.onlinestore.service.InventoryService;
import com.ideas2it.onlinestore.util.customException.OnlineStoreException;

/**
 * This class performs read, add quantity, add quantity, and delete operation 
 * This class pass the data into inventory repository
 *
 * @version 1.0
 * @author arunkumar
 */
@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	/** 
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Inventory> getInventoryProducts() throws OnlineStoreException {
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
				throw new OnlineStoreException("your list is empty");
			}
			return filterInventoryProducts;
		} else {
			throw new OnlineStoreException("your list is empty");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean decreaseQuantity(String productName) throws OnlineStoreException {
		Inventory inventory = inventoryRepository.findByProductName(productName);
		if (null != inventory) {
			inventory.setQuantity(inventory.getQuantity() - 1);
			return inventoryRepository.save(inventory).equals(inventory);
		} else {
			throw new OnlineStoreException("your data not found");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteInventoryProducts(int id) throws OnlineStoreException {
		Inventory inventory = getInventoryProductById(id);
	    inventory.setStatus(true);
	    return inventoryRepository.save(inventory).equals(inventory);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Inventory getInventoryProductById(int id) throws OnlineStoreException {
		Inventory inventory = inventoryRepository.findById(id).orElse(null);
		if (inventory == null || inventory.isStatus()){
			throw new OnlineStoreException("your data not found");
		}
		return inventory;
	}
}
