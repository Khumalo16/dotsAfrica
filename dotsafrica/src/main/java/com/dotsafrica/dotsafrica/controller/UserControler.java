package com.dotsafrica.dotsafrica.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotsafrica.dotsafrica.request.UserRequest;
import com.dotsafrica.dotsafrica.services.UserService;

@RestController
@RequestMapping(path="/api")
public class UserControler {
    
    @Autowired
    private UserService service;

    @PostMapping(path="/register")
    public String addUser(@Valid @RequestBody UserRequest user) {
        return this.service.addUser(user);
    }
}
