package com.ideas2it.onlinestore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.onlinestore.model.Product;
import com.ideas2it.onlinestore.repository.ProductRepository;
import com.ideas2it.onlinestore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository; 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> viewProducts() {
		return productRepository.findAll();
	}

	/**
     * {@inheritDoc}
     */
    @Override
	public boolean isProductsEmpty() {
		return productRepository.findAll().isEmpty();
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isProductExist(int productId) {
        return null != productRepository.findById(productId);        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isProductUpdated(Product product) {  
        return  product != productRepository.save(product);
    }

    /**
     * {@inheritDoc}
     */
	@Override
    public Product viewProduct(int productId) { 
		return productRepository.findById(productId);
    }

	/**
     * {@inheritDoc}
     */
	@Override
	public Product deleteProduct(Product product) {
		product.setStatus(true);
		return productRepository.save(product);     
    }
}
