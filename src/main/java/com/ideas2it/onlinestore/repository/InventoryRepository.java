package com.ideas2it.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideas2it.onlinestore.model.Inventory;

/**
 * This interface handles inventory read, add quantity, add quantity, and delete 
 * operation as well as read operation by product by name
 *
 * @version 1.0
 * @author arunkumar
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	/**
	 * This method is used to get inventory product if it is valid 
	 * its return inventory object else it null 
	 * 
	 * @param productName
	 * @return inventory products
	 */
	@Query("from Inventory where productName = :productName and status = false")
	Inventory findByProductName(String productName);
}
