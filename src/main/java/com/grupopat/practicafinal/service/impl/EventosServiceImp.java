package com.grupopat.practicafinal.service.impl;

import com.grupopat.practicafinal.model.EventosModel;
import com.grupopat.practicafinal.repository.EventosRepository;
import com.grupopat.practicafinal.service.EventosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EventosServiceImp implements EventosService {
    @Autowired
    EventosRepository EventosRepository; 

   
   
    @Override
    public Iterable<EventosModel> getEventosByUser(String username){

        return EventosRepository.getEventosByUser(username); 
        
    }

    @Override
    public EventosModel create(EventosModel user) {
       // user.setId_gasto(null);
        return EventosRepository.save(user);
    }



}