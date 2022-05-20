package com.grupopat.practicafinal.service.impl;

import com.grupopat.practicafinal.model.GastoModel;
import com.grupopat.practicafinal.repository.GastoRepository;
import com.grupopat.practicafinal.service.GastoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoServiceImp implements GastoService{
   
    @Autowired
    GastoRepository gastoRepository; 


    @Override
    public Iterable<GastoModel> getGastosByPeriodo(String gastos_name,String user_name)
    {

        return gastoRepository.getGastosByPeriodo(gastos_name,user_name); 
        
    }
    @Override
    public GastoModel create(GastoModel user) {
       // user.setId_gasto(null);
        return gastoRepository.save(user);
    }
    
   
}
