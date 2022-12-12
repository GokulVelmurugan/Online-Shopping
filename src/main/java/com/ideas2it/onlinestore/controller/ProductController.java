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

import com.ideas2it.onlinestore.model.Product;
import com.ideas2it.onlinestore.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/insert")
	private ResponseEntity<Object> insertProduct(@Valid @RequestBody Product product) {
		return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
	}

	@GetMapping("/viewAll")
	private ResponseEntity<Object> viewProducts() {
		List<Product> products = new ArrayList<Product>();

		if (!productService.isProductsEmpty()) {
			products = productService.viewProducts();
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	private ResponseEntity<Object> updateProduct(@Valid @PathVariable(value = "id") int productId, @RequestBody Product product) {
        Map<String, String> successMessage = new HashMap<String, String>();
		if (!productService.isProductsEmpty()) {

			if (null != productService.viewProduct(productId)) {

				if (productService.isProductUpdated(product)) {
					successMessage.put("message", "Updated successfully");
				}
			}
		}
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	private ResponseEntity<Product> viewProduct(@PathVariable(value = "id") int productId) {
		Product currentProduct = null;

		if (!productService.isProductsEmpty()) {
			currentProduct = productService.viewProduct(productId);
		}
		return new ResponseEntity<>(currentProduct, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	private ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") int productId) {
		Map<String, String> successMessage = new HashMap<String, String>();
		Product product = null;

		if (!productService.isProductsEmpty()) {

			if (productService.isProductExist(productId)) {
				product = productService.viewProduct(productId);

				if (null != product) {

					if (null != productService.deleteProduct(product)) {
						successMessage.put("message", "Deleted successfully");
					}
				}
			}
		}
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}
