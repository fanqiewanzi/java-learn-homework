package com.example.learn1.controller;


import com.example.learn1.Response;
import com.example.learn1.dao.UserDao;

import com.example.learn1.modle.User;
import com.example.learn1.service.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/homepage")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("/login")
    Map<String, Object> find(@RequestBody User user)
    {
        return userServiceImp.Login(user);
    }
}
