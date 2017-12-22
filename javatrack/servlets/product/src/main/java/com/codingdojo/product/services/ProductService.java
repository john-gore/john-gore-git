package com.codingdojo.product.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.Product;
import com.codingdojo.product.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository proRepository;
	
	public ProductService(ProductRepository proRepository) {
		this.proRepository = proRepository;
	}
	
	public Product addProduct(Product product) {
		return proRepository.save(product);
	}
	public Product getProduct(Long id) {
		return proRepository.findOne(id);
	}
	public List<Product> availableProducts(Category category) {
		// As of right now, we do not know how to query single columns 
		// using the spring-data-jpa. I will create a list of name from the 
		// products and execute a not in query with the list in the CrudRepository
		List<String> names = new ArrayList<String>();
		List<Product> currentProds = category.getProducts();
		
		if(currentProds.isEmpty()) {
			// add empty string if there are not categories. Since an empty array does not have
			// a list of strings, we do not get any categories back;
			names.add("");	
		} else {
			for(Product p : currentProds) {
				names.add(p.getName());
			}	
		}
			
		List<Product> prods = proRepository.findByNameNotIn(names);
		return prods;
	}
}
