package com.ideas2it.onlinestore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ideas2it.onlinestore.util.constants.Order_Type;

@Entity
@Table(name = "order_list")
public class OrderList extends BaseModel{
	
	@Enumerated(EnumType.STRING)
    private Order_Type order_type; 

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "orderList")
	private List<OrderedProducts> orderedProducts;
	
	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
	private Address address;
	
	public OrderList() {
		super();
	}

	public OrderList(Order_Type order_type, User user, List<OrderedProducts> orderedProducts, Address address) {
		super();
		this.order_type = order_type;
		this.user = user;
		this.orderedProducts = orderedProducts;
		this.address = address;
	}

	public Order_Type getOrder_type() {
		return order_type;
	}

	public void setOrder_type(Order_Type order_type) {
		this.order_type = order_type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderedProducts> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProducts> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
