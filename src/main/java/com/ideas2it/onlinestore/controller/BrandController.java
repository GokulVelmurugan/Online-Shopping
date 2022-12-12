package com.ideas2it.onlinestore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.onlinestore.model.Brand;
import com.ideas2it.onlinestore.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@PostMapping("/insert")
	private ResponseEntity<Brand> insertBrand(@Valid @RequestBody Brand brand) {
		return new ResponseEntity<Brand>(brandService.createBrand(brand), HttpStatus.CREATED);
	}

	@GetMapping("/viewAll")
	private ResponseEntity<Object> viewBrands() {
		List<Brand> brands = new ArrayList<Brand>();

		if (!brandService.isBrandsEmpty()) {
			brands = brandService.viewBrands();
		}
		return new ResponseEntity<>(brands, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	private ResponseEntity<Object> updateBrand(@Valid @PathVariable(value = "id") int brandId, @RequestBody Brand brand) {
		Map<String, String> successMessage = new HashMap<String, String>();

		if (!brandService.isBrandsEmpty()) {

			if (null != brandService.viewBrand(brandId)) {

				if (brandService.isBrandUpdated(brand)) {
					successMessage.put("message", "Updated successfully");
				}
			}
		}
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	private ResponseEntity<Brand> viewBrand(@PathVariable(value = "id") int brandId) {
		Brand currentBrand = null;

		if (!brandService.isBrandsEmpty()) {
			currentBrand = brandService.viewBrand(brandId);
		}
		return new ResponseEntity<>(currentBrand, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	private ResponseEntity<Object> deleteBrand(@PathVariable(value = "id") int brandId) {
		Brand brand = null;
		Map<String, String> successMessage = new HashMap<String, String>();

		if (!brandService.isBrandsEmpty()) {

			if (brandService.isBrandExist(brandId)) {
				brand = brandService.viewBrand(brandId);

				if (null != brand) {

					if (null != brandService.deleteBrand(brand)) {
						successMessage.put("message", "Deleted successfully");
					}
				}
			}
		}
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}

