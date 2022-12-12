package com.ideas2it.onlinestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ideas2it.onlinestore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "from Product where id = :productId and status = 0")
	public Product findById(int productId);
	
	@Query(value = "from Product where status = 0")
	public List<Product> findAll();
}
