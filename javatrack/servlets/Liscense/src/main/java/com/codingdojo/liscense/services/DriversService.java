package com.codingdojo.liscense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.liscense.models.License;
import com.codingdojo.liscense.models.Person;
import com.codingdojo.liscense.repositories.DriversRepository;
import com.codingdojo.liscense.repositories.LicenseRepository;

@Service
public class DriversService {
	
	private final DriversRepository dRepo;
	private final LicenseRepository lRepo;
	
	public DriversService (DriversRepository dRepo,  LicenseRepository lRepo) {
		this.dRepo = dRepo;
		this.lRepo = lRepo;
	}
	
	
	public List<Person> getPeople() {
		return dRepo.findAll();
	}
	
	public void addPerson(Person p) {
		Person np = dRepo.save(p);
		System.out.println(np);
	}
	public void addLicense(License l) {
		License nl = lRepo.save(l);
		System.out.println(nl);
	}
	public Person findOne(Long id) {
		return dRepo.findOne(id);
	}
}
