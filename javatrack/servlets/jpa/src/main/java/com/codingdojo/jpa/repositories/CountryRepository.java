package com.codingdojo.jpa.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.jpa.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{
	List<Country> findAll();
	
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = ?1 ORDER BY l.percentage DESC ")
    public List<Object[]> findCountryandLanguageByLanguage(String language);
    
    
    
    @Query("SELECT c.name, COUNT(c.id) AS num_cities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY num_cities DESC")
    public List<Object[]> findCitiesPerCountry();
    
    @Query("SELECT l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > ?1 ORDER BY l.percentage DESC")
    public List<Object[]> findLanguagesPerCountryGreaterThanPercent(Double percentage);
    
    @Query("SELECT c FROM Country c WHERE c.surface_area < ?1 AND c.population > ?2")
    public List<Country> findCountriesSurfaceAreaLessThanPopGreaterThan(Double surface_area, Integer population);
    
    @Query("SELECT c FROM Country c WHERE c.goverment_form =?1 AND c.capital > ?2 AND c.life_expectancy > ?3")
    public List<Country> findCountryCapitalGreaterThanLifeExpectancyLessThan(String goverment_form, Integer capital, Double life_expectancy);
    
    @Query("SELECT c.name, ci.name, ci.district, ci.population FROM Country c JOIN c.cities ci WHERE c.name =?1 AND ci.district = ?2 AND ci.population > ?3")
    public List<Object[]> findCityInDistrictWithPopGreaterThan(String country, String district, Integer population);
    
    @Query("SELECT c.region, count(c.id) FROM Country c GROUP BY c.region ORDER BY count(c.id) DESC")
    public List<Object[]> findCountriesInRegionByNumberDescending();
}
