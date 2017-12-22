package com.codingdojo.product.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.product.models.CategoriesProducts;
import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.Product;
import com.codingdojo.product.repositories.CategoriesProductsRepository;
import com.codingdojo.product.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository catRepository;
	private final CategoriesProductsRepository catProdRepository;
	
	public CategoryService(CategoryRepository catRepository, CategoriesProductsRepository catProdRepository) {
		this.catRepository = catRepository;
		this.catProdRepository = catProdRepository;
	}
	
	public List<Category> getAll() {
		return (List<Category>) catRepository.findAll();
	}
	
	public Category createCategory(Category category) {
		return catRepository.save(category);
	}
	
	public Category getCategory(Long id) {
		return catRepository.findOne(id);
	}
	public List<Category> availableCategories(Product product) {
		// As of right now, we do not know how to query single columns 
		// using the spring-data-jpa. I will create a list of name from the 
		// products and execute a not in query with the list in the CrudRepository
		List<String> names = new ArrayList<String>();
		List<Category> currentCats = product.getCategories();
		
		if(currentCats.isEmpty()) {
			// add empty string if there are not categories. Since an empty array does not have
			// a list of strings, we do not get any categories back;
			names.add("");	
		} else {
			for(Category c : currentCats) {
				names.add(c.getName());
			}	
		}
			
		List<Category> cats = catRepository.findByNameNotIn(names);
		return cats;
	}
	public void addCategory(CategoriesProducts catProd) {
		catProdRepository.save(catProd);
	}
}
