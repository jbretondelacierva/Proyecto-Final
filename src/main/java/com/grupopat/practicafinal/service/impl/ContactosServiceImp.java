package com.grupopat.practicafinal.service.impl;

import com.grupopat.practicafinal.model.ContactosModel;
import com.grupopat.practicafinal.repository.ContactosRepository;
import com.grupopat.practicafinal.service.ContactosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContactosServiceImp implements ContactosService {
    @Autowired
    ContactosRepository contactosRepository; 

   
   
    @Override
    public Iterable<ContactosModel> getContactosByUser(String username){

        return contactosRepository.getContactosByUser(username); 
        
    }

    @Override
    public ContactosModel create(ContactosModel user) {
        return contactosRepository.save(user);
    }
}
    

