package com.kot.spring.Rest.Controller;

import com.kot.spring.Rest.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ConsumeAPIController {

    @Autowired
    private  RestTemplate restTemplate;

    public  final String url = "http://94.198.50.185:7081/api/users/";



    public  List<String>  getUsersList() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request1 = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity1 = restTemplate.exchange(url, HttpMethod.GET, request1, String.class);
        List<String> cookies = responseEntity1.getHeaders().get("Set-Cookie");

        System.out.println(cookies);
        HttpStatus httpStatus = responseEntity1.getStatusCode();
        System.out.println("Status code:  " + httpStatus);
        String response = responseEntity1.getBody();
        System.out.println("Body:  " + response);
        return cookies;
    }

    public String postUser(List<String> cookies){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));

        HttpEntity<User> entity = new HttpEntity<User>(new User(3L,"James", "Brown", (byte)35), headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        HttpStatus httpStatus = responseEntity.getStatusCode();
        System.out.println("Status code:  " + httpStatus);
        String response = responseEntity.getBody();
        System.out.println("Body:  " + response);
        return response;
    }


    public String putUser(List<String> cookies){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));

        HttpEntity<User> entity = new HttpEntity<User>(new User(3L,"Thomas", "Shelby", (byte)35), headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);

        HttpStatus httpStatus = responseEntity.getStatusCode();
        System.out.println("Status code:  " + httpStatus);
        String response = responseEntity.getBody();
        System.out.println("Body:  " + response);
        return response;
    }

    public String deleteUser(List<String> cookies){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url + 3, HttpMethod.DELETE, entity, String.class);

        HttpStatus httpStatus = responseEntity.getStatusCode();
        System.out.println("Status code:  " + httpStatus);
        String response = responseEntity.getBody();
        System.out.println("Body:  " + response);
        return response;
    }















}
