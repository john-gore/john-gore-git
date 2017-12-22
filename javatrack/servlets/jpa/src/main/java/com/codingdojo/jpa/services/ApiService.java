package com.codingdojo.jpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.jpa.models.Country;
import com.codingdojo.jpa.repositories.CityRepository;
import com.codingdojo.jpa.repositories.CountryRepository;
@Service
public class ApiService {
	private CountryRepository countryRepo;
	private CityRepository cityRepo;
	
	public ApiService(CountryRepository countryRepository, CityRepository cityRepository) {
		countryRepo = countryRepository;
		cityRepo = cityRepository;
	}
	
	public List<Object[]> findCountryandLanguageByLanguage(String language) {
		return countryRepo.findCountryandLanguageByLanguage(language);
	}
	public List<Object[]> findCitiesPerCountry() {
		return countryRepo.findCitiesPerCountry();
	}
	public List<Object[]> findCitiesInCountryWherePOPGreaterThan(String country, Integer population) {
		return cityRepo.findCitiesInCountryWherePOPGreaterThan(country, population);
	}
	public List<Object[]> findLanguagesPerCountryGreaterThanPercent(Double percentage) {
		return countryRepo.findLanguagesPerCountryGreaterThanPercent(percentage);
	}
	public List<Country> findCountriesSurfaceAreaLessThanPopGreaterThan(Double surface_area, Integer population) {
		return countryRepo.findCountriesSurfaceAreaLessThanPopGreaterThan(surface_area, population);
	}
	
	public List<Object[]> findCityInDistrictWithPopGreaterThan(String country, String district, Integer population) {
		return countryRepo.findCityInDistrictWithPopGreaterThan(country, district, population);
	}
	
	public List<Object[]> findCountriesInRegionByNumberDescending() {
		return countryRepo.findCountriesInRegionByNumberDescending();
	}
	
}
