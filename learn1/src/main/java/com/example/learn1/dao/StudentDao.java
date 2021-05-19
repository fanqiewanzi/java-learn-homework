package com.example.learn1.dao;

import com.example.learn1.modle.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    int insert(Student student);

    int delete(Integer id);

    List<Student> findByName(String value);
}
