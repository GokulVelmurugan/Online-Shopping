package com.ideas2it.onlinestore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order extends BaseModel{

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "order")
	private List<OrderedProducts> orderedPoducts;
	
	public Order() {
		super();
	}

	public Order(User user, List<OrderedProducts> orderProducts) {
		super();
		this.user = user;
		this.orderedPoducts = orderProducts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderedProducts> getOrderProducts() {
		return orderedPoducts;
	}

	public void setOrderProducts(List<OrderedProducts> orderProducts) {
		this.orderedPoducts = orderProducts;
	}
	
}
