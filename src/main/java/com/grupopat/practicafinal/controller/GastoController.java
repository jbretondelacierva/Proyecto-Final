package com.grupopat.practicafinal.controller;

import com.grupopat.practicafinal.model.GastoModel;
import com.grupopat.practicafinal.service.GastoService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/v1")
public class GastoController {

    @Autowired
    GastoService gastoService; 
   
    @GetMapping("/gastos/periodo/{periodo_name}/{user_name}")
    public ResponseEntity<Iterable<GastoModel>> getGastosByPeriodo(@PathVariable String periodo_name, @PathVariable String user_name){

        Iterable<GastoModel> response = gastoService.getGastosByPeriodo(periodo_name,user_name);
        return ResponseEntity.ok().body(response); 
    }

    @PostMapping("/gastos")
    public ResponseEntity<GastoModel> postInfo(@RequestBody GastoModel gasto){ 
        GastoModel newGasto = gastoService.create(gasto);
        return ResponseEntity.ok().body(newGasto);
    }

    
}