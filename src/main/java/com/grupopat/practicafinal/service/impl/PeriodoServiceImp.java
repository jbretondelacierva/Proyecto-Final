package com.grupopat.practicafinal.service.impl;

import com.grupopat.practicafinal.model.PeriodoModel;
import com.grupopat.practicafinal.repository.PeriodoRepository;
import com.grupopat.practicafinal.service.PeriodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PeriodoServiceImp implements PeriodoService {
    @Autowired
    PeriodoRepository periodoRepository; 

   
   
    @Override
    public Iterable<PeriodoModel> getPeriodoByUsername(String username){

        return periodoRepository.getPeriodoByUsername(username); 
        
    }
    
}
