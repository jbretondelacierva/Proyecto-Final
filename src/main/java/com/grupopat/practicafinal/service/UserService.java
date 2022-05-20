package com.grupopat.practicafinal.service;

import com.grupopat.practicafinal.model.UserModel;


import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    Iterable<UserModel> retrieveAll();

   
}
