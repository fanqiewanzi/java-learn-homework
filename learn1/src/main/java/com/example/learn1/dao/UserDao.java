package com.example.learn1.dao;

import com.example.learn1.modle.Student;
import com.example.learn1.modle.User;

import java.util.List;

public interface UserDao {
    User getUser(String phoneNumber);

    int insert(User user);

    int delete(Integer id);

    User findById(long value);
}
