package com.codingdojo.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.jpa.models.City;


public interface CityRepository extends CrudRepository<City, Long>{
	List<City> findAll();
	
	@Query("SELECT ci.name, ci.population FROM City ci JOIN ci.country c WHERE c.name = ?1 AND ci.population > ?2 ORDER BY ci.population DESC")
	public List<Object[]> findCitiesInCountryWherePOPGreaterThan(String country, Integer population);
}
