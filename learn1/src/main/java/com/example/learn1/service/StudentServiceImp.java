package com.example.learn1.service;

import com.example.learn1.Response;
import com.example.learn1.dao.StudentDao;
import com.example.learn1.modle.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("StudentServiceImp")
public class StudentServiceImp implements StudentService{
    @Resource
    private StudentDao studentDao;

    @Override
    public Response findStudent() {
        List<Student> studentList = studentDao.findAll();
        studentList.forEach(System.out::println);
        if(studentList.isEmpty())
        { return Response.SUCCESS;}
        else
        {return Response.ERROR;}
    }
}
