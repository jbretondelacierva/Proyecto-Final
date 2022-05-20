package com.grupopat.practicafinal.controller;

import com.grupopat.practicafinal.model.ContactosModel;
import com.grupopat.practicafinal.service.ContactosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class ContactosController {
    @Autowired
    ContactosService contactosService;

    @GetMapping("/contactos/{user_name}")
    public ResponseEntity<Iterable<ContactosModel>> getContactosByPeriodo(@PathVariable String user_name){

        Iterable<ContactosModel> response = contactosService.getContactosByUser(user_name);
        return ResponseEntity.ok().body(response); 
    }
    
    @PostMapping("/contactos")
    public ResponseEntity<ContactosModel> postInfo(@RequestBody ContactosModel gasto){ 
        ContactosModel newGasto = contactosService.create(gasto);
        return ResponseEntity.ok().body(newGasto);
    }
    

}