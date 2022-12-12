package com.ideas2it.onlinestore.service;

import java.util.List;

import com.ideas2it.onlinestore.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product);

	public List<Product> viewProducts();

	public boolean isProductsEmpty();

	public boolean isProductExist(int productId);

	public boolean isProductUpdated(Product product);

	public Product viewProduct(int productId);

	public Product deleteProduct(Product product);

}
