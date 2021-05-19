package com.example.learn1.controller;

import com.example.learn1.Response;
import com.example.learn1.service.StudentServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentServiceImp studentServiceImp;

   @RequestMapping("/find")
    Response find()
    {
        return studentServiceImp.findStudent();
    }

}