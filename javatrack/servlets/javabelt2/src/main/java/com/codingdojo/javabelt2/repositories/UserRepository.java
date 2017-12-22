package com.codingdojo.javabelt2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javabelt2.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
	User findOne(Long id);
}