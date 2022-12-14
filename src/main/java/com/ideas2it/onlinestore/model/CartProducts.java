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
	
	@Column(name = "price", columnDefinition = "int not null")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public CartProducts() {
		super();
	}

	public CartProducts(int quantity, double price, Cart cart, Product product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.cart = cart;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
