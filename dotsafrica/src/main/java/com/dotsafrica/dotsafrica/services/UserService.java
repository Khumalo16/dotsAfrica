package com.dotsafrica.dotsafrica.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsafrica.dotsafrica.entity.AppUser;
import com.dotsafrica.dotsafrica.extend.UserServices;
import com.dotsafrica.dotsafrica.repository.UserRepository;
import com.dotsafrica.dotsafrica.request.UserRequest;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService implements UserServices{

    @Autowired
    private final UserRepository userRepository;

    @Override
    public String addUser(UserRequest userRequest) {
        
        if (userRequest.getUsername() == null) throw new IllegalStateException("Username not provided");  
        Optional<AppUser> optUser = userRepository.findUserByUsername(userRequest.getUsername());
        if (optUser.isPresent())  throw new IllegalStateException("Username taken");
        AppUser user = new AppUser();
        user.setUsername(userRequest.getUsername());
        userRepository.save(user);
        return user.getUsername();
    }
}
