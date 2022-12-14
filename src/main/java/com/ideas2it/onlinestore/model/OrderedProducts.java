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
	@JoinColumn(name = "order_list_id", nullable = false)
	private OrderList orderList;

	public OrderedProducts() {
		super();
	}

	public OrderedProducts(int quantity, Product product, OrderList order) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.orderList = order;
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

	public OrderList getOrder() {
		return orderList;
	}

	public void setOrder(OrderList order) {
		this.orderList = order;
	}	
	
}
