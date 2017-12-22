package com.codingdojo.overflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.Answer;
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

}
