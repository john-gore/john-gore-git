package com.codingdojo.eventsbeltreviewer.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.repositories.UserRepo;


@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserRepo uRepo;
    //this is not in sams or any others, may or may not work!
//    private SimpleGrantedAuthority userDefualt = new SimpleGrantedAuthority("ROLE_USER");
    
    public UserDetailsServiceImplementation(UserRepo uRepo){
        this.uRepo = uRepo;
    }
    // 1
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = uRepo.findByEmail(email);
        
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities());
    }
    
    // 2 check to see if there are any issues
    private List<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> retList = new ArrayList<GrantedAuthority>();
        GrantedAuthority userAuth = new SimpleGrantedAuthority("ROLE_USER");
        retList.add(userAuth);
        return retList;
    }
}
  