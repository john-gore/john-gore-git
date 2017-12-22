package com.codingdojo.dojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojo.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{

}
