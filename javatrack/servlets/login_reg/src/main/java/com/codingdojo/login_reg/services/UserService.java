package com.codingdojo.login_reg.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.login_reg.models.User;
import com.codingdojo.login_reg.repositories.RoleRepository;
import com.codingdojo.login_reg.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository uRepo;
    private RoleRepository rRepo;
    private BCryptPasswordEncoder bCrypt;
    
    public UserService(UserRepository uRepo, RoleRepository rRepo, BCryptPasswordEncoder bCrypt)     {
        this.uRepo = uRepo;
        this.rRepo = rRepo;
        this.bCrypt = bCrypt;
    }
 // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        user.setRoles(rRepo.findByName("ROLE_USER"));
        uRepo.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        user.setRoles(rRepo.findByName("ROLE_ADMIN"));
        uRepo.save(user);
    }    
    
    // 3
    public User findByEmail(String email) {
        return uRepo.findByEmail(email);
    }
}
