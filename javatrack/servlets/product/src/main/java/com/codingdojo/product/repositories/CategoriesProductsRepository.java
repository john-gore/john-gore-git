package com.codingdojo.product.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.product.models.CategoriesProducts;

public interface CategoriesProductsRepository extends CrudRepository<CategoriesProducts, Long> {

}
