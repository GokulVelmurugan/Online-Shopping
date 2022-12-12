package com.ideas2it.onlinestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ideas2it.onlinestore.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	@Query(value = "from Brand where id = :brandId and status = 0")
	public Brand findById(int brandId);

	@Query(value = "from Brand where status = 0")
	public List<Brand> findAll();
}
