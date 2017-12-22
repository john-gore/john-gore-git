package com.codingdojo.product.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.product.models.CategoriesProducts;
import com.codingdojo.product.models.Product;
import com.codingdojo.product.services.CategoryService;
import com.codingdojo.product.services.ProductService;

@Controller
public class Products {
	private final ProductService proService;
	private final CategoryService catService;
	
	public Products(ProductService proService, CategoryService catService) {
		this.proService = proService;
		this.catService = catService;
	}
	
	
	@RequestMapping("/")
	public String index(@ModelAttribute("product") Product products) {
		System.out.println("here");
		return "newproduct.jsp";
	}
	
	
	@PostMapping("/products")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		} 
		//send person to the service
		Product prod = proService.addProduct(product);
		String prodId = Long.toString(prod.getId());
		System.out.println("product to save");
		return "redirect:/product/".concat(prodId);
	}
	
	@RequestMapping("/product/{id}")
	public String showProduct(@ModelAttribute("catProd") CategoriesProducts catProd, @PathVariable("id") Long id, Model model) {
		Product product = proService.getProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", catService.availableCategories(product));
		return "category.jsp";
	}
	
}
