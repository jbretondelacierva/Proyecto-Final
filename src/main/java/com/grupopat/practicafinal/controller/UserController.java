package com.grupopat.practicafinal.controller;


import com.grupopat.practicafinal.model.UserModel;
import com.grupopat.practicafinal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.userdetails.User;


@Controller
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;
  
   
    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModel>> retrieveAll(@AuthenticationPrincipal User user){
        System.out.println(user.getUsername());
        return ResponseEntity.ok().body(userService.retrieveAll()); 
    }

   
  
}