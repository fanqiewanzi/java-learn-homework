package com.learn.demo.dao;


import com.learn.demo.POJO.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDao {

   List<Student> findAll();

    int insert(Student student);

    int delete(Integer id);

    List<Student> findByName(String value);
}
