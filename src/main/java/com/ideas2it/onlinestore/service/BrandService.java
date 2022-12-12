package com.ideas2it.onlinestore.service;

import java.util.List;

import com.ideas2it.onlinestore.model.Brand;

public interface BrandService {

	public Brand createBrand(Brand brand);

	public List<Brand> viewBrands();

	public boolean isBrandsEmpty();

	public boolean isBrandExist(int brandId);

	public boolean isBrandUpdated(Brand brand);

	public Brand viewBrand(int brandId);

	public Brand deleteBrand(Brand brand);
}
