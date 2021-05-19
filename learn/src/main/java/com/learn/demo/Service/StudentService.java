package com.learn.demo.Service;

import com.learn.demo.dao.StudentDao;
import com.learn.demo.POJO.Student;
import com.learn.demo.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("StudentService")
public class StudentService implements StudentServiceInterface{
    @Resource
    private StudentDao studentDao;

    @Override
    public Response findStudent() {
        List<Student> studentList = studentDao.findAll();
        studentList.forEach(System.out::println);
        return Response.SUCCESS;
    }
}
