package com.kenny.springevents.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kenny.springevents.models.GetTogether;

@Repository
public interface GetTogetherRepository extends CrudRepository<GetTogether, Long> {
	List<GetTogether> findByStateLike(String state);
	List<GetTogether> findByStateNotLike(String state);
	GetTogether findOne(Long id);
	
}
