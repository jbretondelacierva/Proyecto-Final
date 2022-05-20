package com.grupopat.practicafinal.service;
import com.grupopat.practicafinal.model.PeriodoModel;

public interface PeriodoService {
    Iterable<PeriodoModel> getPeriodoByUsername(String username);
    

   
}