package com.codingdojo.jpa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue
	private Long id;
	
	private String code;
	private String name;
	private String region;
	private Double surface_area;
	private Integer indep_year;
	private Integer population;
	private Double life_expectancy;
	private Double gnp;
	private Double old_gnp;
	private String local_name;
	private String goverment_form;
	private String head_of_state;
	private Integer capital;
	private String code2;
	
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<City> cities;
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<Language> languages;

	public Country() {
	        
	    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(Double surface_area) {
		this.surface_area = surface_area;
	}

	public Integer getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(Integer indep_year) {
		this.indep_year = indep_year;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Double getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(Double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public Double getGnp() {
		return gnp;
	}

	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}

	public Double getOld_gnp() {
		return old_gnp;
	}

	public void setOld_gnp(Double old_gnp) {
		this.old_gnp = old_gnp;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGoverment_form() {
		return goverment_form;
	}

	public void setGoverment_form(String goverment_form) {
		this.goverment_form = goverment_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	
	
}










