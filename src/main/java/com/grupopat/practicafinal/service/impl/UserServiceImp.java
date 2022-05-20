package com.grupopat.practicafinal.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.grupopat.practicafinal.model.UserModel;
import com.grupopat.practicafinal.repository.UserRepository;
import com.grupopat.practicafinal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository; 

   
   
    @Override
    public Iterable<UserModel> retrieveAll(){
        return userRepository.findAll(); 
        
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserModel user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails newUser = new User(user.getUsername(), user.getContrasena(), authorities);
        return newUser;
    }

    
    
}
