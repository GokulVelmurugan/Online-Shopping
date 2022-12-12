package com.ideas2it.onlinestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_products")
public class CartProducts extends BaseModel{

	@Column(name = "quantity", columnDefinition = "int not null")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public CartProducts() {
		super();
	}

	public CartProducts(int quantity, Cart cart, Product product) {
		super();
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
