package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Inventory extends BaseModel {
 
	@Column(name = "product_name", columnDefinition = "varchar(30) unique")
	private String productName;
	
	@Column(name = "quantity", columnDefinition = "int not null")	
	private int quantity;
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
