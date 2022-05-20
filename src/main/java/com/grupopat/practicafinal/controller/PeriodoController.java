package com.grupopat.practicafinal.controller;

import com.grupopat.practicafinal.model.PeriodoModel;
import com.grupopat.practicafinal.service.PeriodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

@Controller
@RequestMapping("/api/v1")
public class PeriodoController {
    @Autowired
    PeriodoService periodoService;
  
   

    @GetMapping("/users/periodos")
    public ResponseEntity<Iterable<PeriodoModel>> retrieveAll(@AuthenticationPrincipal User user){
        System.out.println(user.getUsername());
        String username= user.getUsername();
        Iterable<PeriodoModel> reponse = periodoService.getPeriodoByUsername(username);
        for(PeriodoModel periodoModel: reponse){
            System.out.println(periodoModel.toString());
        }
        return ResponseEntity.ok().body(reponse); 
    }

}