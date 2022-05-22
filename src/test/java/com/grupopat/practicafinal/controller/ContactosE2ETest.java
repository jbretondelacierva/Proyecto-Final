package com.grupopat.practicafinal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import com.grupopat.practicafinal.model.ContactosModel;
import com.grupopat.practicafinal.model.EventosModel;
import com.grupopat.practicafinal.model.GastoModel;
import com.grupopat.practicafinal.model.UserModel;
import com.grupopat.practicafinal.repository.ContactosRepository;
import com.grupopat.practicafinal.repository.GastoRepository;
import com.grupopat.practicafinal.repository.UserRepository;
import com.grupopat.practicafinal.service.ContactosService;
import com.grupopat.practicafinal.service.EventosService;
import com.grupopat.practicafinal.service.GastoService;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ContactosE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ContactosRepository contactoRepository;

    @Autowired
    private ContactosService contactosService; 

  

    @Test
    public void getContactosTest(){
        
        Iterable<ContactosModel> response = contactosService.getContactosByUser("user1");
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/contactos/user1"; 
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic dXNlcjE6MTIz");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<ContactosModel>> result = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<ContactosModel>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(response);

    }
}


