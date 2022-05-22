package com.grupopat.practicafinal.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;



import com.grupopat.practicafinal.model.ContactosModel;
import com.grupopat.practicafinal.model.UserModel;
import com.grupopat.practicafinal.service.ContactosService;
import com.grupopat.practicafinal.service.UserService;

import static org.assertj.core.api.BDDAssertions.then;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UsersE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Autowired
    private UserService userService; 

  

    @Test
    public void getUsersTest(){
        
        Iterable<UserModel> response = userService.retrieveAll();
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users"; 
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic dXNlcjE6MTIz");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserModel>> result = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<UserModel>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(response);

    }
}

