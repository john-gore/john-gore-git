package com.codingdojo.liscense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.liscense.models.Person;

public interface DriversRepository extends CrudRepository<Person, Long>{
	public List<Person> findAll();
	public Person save(Person person);
	public Person findOne(Long id);
}
