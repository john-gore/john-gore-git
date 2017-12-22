package com.codingdojo.javabelt2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.javabelt2.models.Post;
import com.codingdojo.javabelt2.models.User;
import com.codingdojo.javabelt2.repositories.PostRepository;




@Service
public class PostService {
private PostRepository postRepo;
	
	public PostService(PostRepository postRepository) {
		postRepo = postRepository;
	}

	public void save(Post post) {
		postRepo.save(post);
	}
	
	public void delete(Post post) {
		postRepo.delete(post);
	}

	public List<Post> findAll() {
		return postRepo.findAll();
	}

	public Post findOne(Long id) {
		return postRepo.findOne(id);
	}

	public List<Object[]> findPostsByLikes(Integer userlikes){
		return postRepo.findPostsByLikes(userlikes);
	}
}
