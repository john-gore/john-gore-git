package com.codingdojo.product.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.product.models.CategoriesProducts;
import com.codingdojo.product.models.Category;
import com.codingdojo.product.services.CategoryService;
import com.codingdojo.product.services.ProductService;


@Controller

public class Categories {
	private final ProductService proService;
	private final CategoryService catService;
	
	public Categories(ProductService proService, CategoryService catService) {
		this.proService = proService;
		this.catService = catService;
	}
	
	@RequestMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newcategory.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		} else {
			Category cat = catService.createCategory(category);
			String catId = Long.toString(cat.getId());
			return "redirect:/".concat(catId);
		}
	}
	
	@RequestMapping("/{id}")
	public String showCategory(@ModelAttribute("catProd") CategoriesProducts catProd, @PathVariable("id") Long id, Model model) {
		Category category = catService.getCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", proService.availableProducts(category));
		return "category.jsp";
	}

}