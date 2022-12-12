package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String> {

	Inventory findByProductName(String productName);
}
