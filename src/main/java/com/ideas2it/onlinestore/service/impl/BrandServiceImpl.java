package com.ideas2it.onlinestore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ideas2it.onlinestore.model.Brand;
import com.ideas2it.onlinestore.repository.BrandRepository;
import com.ideas2it.onlinestore.service.BrandService;

public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository; 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Brand createBrand(Brand brand) {
		return brandRepository.save(brand);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Brand> viewBrands() {
		return brandRepository.findAll();
	}

	/**
     * {@inheritDoc}
     */
    @Override
	public boolean isBrandsEmpty() {
		return brandRepository.findAll().isEmpty();
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBrandExist(int brandId) {
        return null != brandRepository.findById(brandId);        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBrandUpdated(Brand brand) {  
        return  brand != brandRepository.save(brand);
    }

    /**
     * {@inheritDoc}
     */
	@Override
    public Brand viewBrand(int brandId) { 
		return brandRepository.findById(brandId);
    }

	/**
     * {@inheritDoc}
     */
	@Override
	public Brand deleteBrand(Brand brand) {
		brand.setStatus(true);
		return brandRepository.save(brand);     
    }

}
