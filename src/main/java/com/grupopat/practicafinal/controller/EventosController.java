package com.grupopat.practicafinal.controller;

import com.grupopat.practicafinal.model.EventosModel;
import com.grupopat.practicafinal.service.EventosService;

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
public class EventosController {
    @Autowired
    EventosService eventosService;

    @GetMapping("/eventos/{user_name}")
    public ResponseEntity<Iterable<EventosModel>> getEventosByUser(@PathVariable String user_name){

        Iterable<EventosModel> response = eventosService.getEventosByUser(user_name);
        return ResponseEntity.ok().body(response); 
    }

    @PostMapping("/eventos")
    public ResponseEntity<EventosModel> postInfo(@RequestBody EventosModel gasto){ 
        EventosModel newGasto = eventosService.create(gasto);
        return ResponseEntity.ok().body(newGasto);
    }
    

}