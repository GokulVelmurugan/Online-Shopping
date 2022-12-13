package com.ideas2it.onlinestore.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart extends BaseModel {
	
	@Column(name = "total_value")
	private double totalValue;
	
	@OneToMany(mappedBy = "cart")
	private List<CartProducts> cartProducts;
	
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Cart() {
		super();
	}

	public Cart(double totalValue, List<CartProducts> cartProducts, User user) {
		super();
		this.totalValue = totalValue;
		this.cartProducts = cartProducts;
		this.user = user;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public List<CartProducts> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProducts> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
