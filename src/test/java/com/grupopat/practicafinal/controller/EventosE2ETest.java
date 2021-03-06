package com.grupopat.practicafinal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;


import com.grupopat.practicafinal.model.EventosModel;
import com.grupopat.practicafinal.service.EventosService;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventosE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    

    @Autowired
    private EventosService eventosService; 

    @Test
    public void getEventosByUser(){
        
        Iterable<EventosModel> response = eventosService.getEventosByUser("user1");
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/eventos/user1";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic dXNlcjE6MTIz");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<EventosModel>> result = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<EventosModel>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(response);

    }

    @Test
    public void eventoPostTest(){
        EventosModel evento = new EventosModel();
        
        evento.setUsername("user1");
        evento.setNombre("fiesta");
        evento.setDescripcion("planazo");
        evento.setMes("agosto");
        
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/eventos";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic dXNlcjE6MTIz");

        HttpEntity<EventosModel> entity = new HttpEntity<>(evento,headers);

        ResponseEntity<EventosModel> result = restTemplate.exchange(
            url,
            HttpMethod.POST,
            entity,
            new ParameterizedTypeReference<EventosModel>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}




