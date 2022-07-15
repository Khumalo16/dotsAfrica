package com.dotsafrica.dotsafrica.controller;

import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dotsafrica.dotsafrica.request.UserRequest;
import com.dotsafrica.dotsafrica.services.UserService;

@RestController
@RequestMapping(path="/api")
public class UserControler {
    
    @Autowired
    private UserService service;

    @PostMapping(path="/register")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserRequest user) {

        URI uri =  URI.
        create(ServletUriComponentsBuilder.
        fromCurrentContextPath().path("/register").
        toUriString());
        return ResponseEntity.created(uri).body(this.service.addUser(user));
    }
}
