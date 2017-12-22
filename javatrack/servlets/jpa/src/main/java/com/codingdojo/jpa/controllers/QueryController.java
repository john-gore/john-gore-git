package com.codingdojo.jpa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.jpa.models.Country;
import com.codingdojo.jpa.services.ApiService;

@Controller
public class QueryController {
	
	private ApiService apiService;
	
	public QueryController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String index() {
//		
//		List<Object[]> langCountries = apiService.findCountryandLanguageByLanguage("Slovene");
//		for(Object[] row : langCountries) {
//			System.out.println("Country: " + row[0] + " Language: " + row[1] + " Percentage: " + row[2]);
//		}
//		return "index.jsp";
//	}
	
//		List<Object[]> countCityCountry = apiService.findCitiesPerCountry();
//		for(Object[] row : countCityCountry) {
//			System.out.println("Country: " + row[0] + " Number of Cities: " + row[1]);
//		}
//		return "index.jsp";
//	}
		
//		List<Object[]> highPopCity = apiService.findCitiesInCountryWherePOPGreaterThan("Mexico", 500000);
//			for(Object[] row : highPopCity) {
//				System.out.println("Country: " + row[0] + " Number of Cities: " + row[1]);
//			}
//		return "index.jsp";
//	}
//		List<Object[]> languagePercentGreaterThan = apiService.findLanguagesPerCountryGreaterThanPercent(89.0);
//				for(Object[] row : languagePercentGreaterThan) {
//					System.out.println("Langauge: " + row[0] + " Percent: " + row[1]);
//				}
//		return "index.jsp";
//	}
//		List<Country> findCountriesSurfaceAreaLessThanPopGreaterThan = apiService.findCountriesSurfaceAreaLessThanPopGreaterThan(501.0, 100000);
//		for(Country row : findCountriesSurfaceAreaLessThanPopGreaterThan) {
//			System.out.println("Country: " + row.getName() + " Surface Area: " + row.getSurface_area() + " Population : " + row.getPopulation());
//		}
//			return "index.jsp";
//	}
//		List<Object[]> findCities = apiService.findCityInDistrictWithPopGreaterThan("Argentina", "Buenos Aires", 500000);
//		for(Object[] row : findCities) {
//			System.out.println("Cities: " + row[0] + " City Name: " + row[1] + " Cistrict : " + row[2] + "Population: " + row[3]);
//		}
//			return "index.jsp";
//	}
		List<Object[]> findCities = apiService.findCountriesInRegionByNumberDescending();
		for(Object[] row : findCities) {
			System.out.println("Region: " + row[0] + " CNumber of Countries: " + row[1]);
		}
			return "index.jsp";
	}	
}
	
	

