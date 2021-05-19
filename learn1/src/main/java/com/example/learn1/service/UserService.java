package com.example.learn1.service;

import com.example.learn1.Response;
import com.example.learn1.modle.User;

import java.util.Map;

public interface UserService {
    Response Rigist();
    Map<String,Object> Login(User user);
}
