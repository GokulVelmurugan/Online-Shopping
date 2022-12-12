package com.ideas2it.onlinestore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient; 

@Entity
@Table(name = "product")
public class Product extends BaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "size")
	private int size;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "sub_category")
	private String subCategory;	
	
	@Transient
	private User seller;
	
	@Transient
	private Inventory inventory;
	
	@Transient
	private Brand brand;
	
	public Product() {}

	public Product(int id, int size, LocalDate expiryDate, String category, String color, String description,
			String name, String subCategory, User seller, Inventory inventory, Brand brand) {
		this.id = id;
		this.size = size;
		this.expiryDate = expiryDate;
		this.category = category;
		this.color = color;
		this.description = description;
		this.name = name;
		this.subCategory = subCategory;
		this.seller = seller;
		this.inventory = inventory;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
