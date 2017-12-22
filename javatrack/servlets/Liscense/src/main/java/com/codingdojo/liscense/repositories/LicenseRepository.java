package com.codingdojo.liscense.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.liscense.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	public License save (License license);

}
