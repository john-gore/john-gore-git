package com.codingdojo.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.product.models.Category;



public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByNameNotIn(List<String> name);
}
