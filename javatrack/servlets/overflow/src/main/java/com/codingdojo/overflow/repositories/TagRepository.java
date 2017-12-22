package com.codingdojo.overflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.Tag;
@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	Tag findBySubject(String subject);

}
