/*
 * Copyright (c) 2022 - 2024 Ideas2it, Inc.All rights are reserved.
 * 
 * This document is protected by copyright. No part of this document may be 
 * reproduced in any form by any means without prior written authorization of 
 * Ideas2it and its licensors, if any.
 */
package com.ideas2it.onlinestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ideas2it.onlinestore.model.Brand;

/**
 * Insert, update, delete, find operations for brand are performed here.
 *
 * @author Sangeetha Ilangovan
 * @version 1.0
 * @since 12.12.2022
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	/**
	 * Finds a brand and returns it by id if it exists otherwise it returns
	 * null.
	 * 
	 * @param brandId - id of the brand
	 * @return brand if it exists otherwise returns null.
	 */
	@Query(value = "from Brand where id = :brandId and status = false")
	public Brand findById(int brandId);

	@Query(value = "from Brand where status = false")
	public List<Brand> findAll();
}
