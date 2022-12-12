package com.ideas2it.onlinestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_products")
public class OrderedProducts extends BaseModel {

	@Column(name = "quantity", columnDefinition = "int NOT NULL")
	private int quantity;
	
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	public OrderedProducts() {
		super();
	}

	public OrderedProducts(int quantity, Product product, Order order) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}	
	
}
