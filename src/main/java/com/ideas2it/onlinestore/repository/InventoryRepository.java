package com.ideas2it.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.onlinestore.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	Inventory findByProductName(String productName);
}
