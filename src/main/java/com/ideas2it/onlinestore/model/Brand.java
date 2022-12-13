/*
 * Copyright (c) 2022 - 2024 Ideas2it, Inc.All rights are reserved.
 * 
 * This document is protected by copyright. No part of this document may be 
 * reproduced in any form by any means without prior written authorization of 
 * Ideas2it and its licensors, if any.
 */
package com.ideas2it.onlinestore.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Implements brand of the product.
 *
 * @author Sangeetha Ilangovan
 * @version 1.0
 * @since 09.12.2022
 */
@Entity
@Table(name = "brand")
public class Brand extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", unique = true)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "brand_id")
	private List<Product> product;
	
	public Brand() {}
	
	public Brand(int id, String name, List<Product> product) {
		this.id = id;
		this.name = name;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
