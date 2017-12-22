package com.codingdojo.javabelt2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javabelt2.models.Post;



@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
	List<Post> findAll();

	@Query("SELECT p FROM Post p ORDER BY userlikes DESC")
	List<Object[]> findPostsByLikes(Integer userlikes);
}