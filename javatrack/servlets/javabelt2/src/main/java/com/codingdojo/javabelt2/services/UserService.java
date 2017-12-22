package com.codingdojo.javabelt2.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.javabelt2.models.User;
import com.codingdojo.javabelt2.repositories.PostRepository;
import com.codingdojo.javabelt2.repositories.RoleRepository;
import com.codingdojo.javabelt2.repositories.UserRepository;



@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository)     {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

	public User findOne(Long id) {
		return userRepository.findOne(id);
	}
	
	


	
}
