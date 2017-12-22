package com.codingdojo.eventsbeltreviewer.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.repositories.UserRepo;





@Service
public class UserService {
	private UserRepo uRepo;
	private BCryptPasswordEncoder bCrypt;
	
	public UserService(UserRepo uRepo, BCryptPasswordEncoder bCrypt) {
		this.uRepo = uRepo;
		this.bCrypt = bCrypt;
	}
	
	public void saveUser(User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        uRepo.save(user);
    }
	
	public User findByEmail(String email) {
        return uRepo.findByEmail(email);
    }
}
