package com.ideas2it.onlinestore.model;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
