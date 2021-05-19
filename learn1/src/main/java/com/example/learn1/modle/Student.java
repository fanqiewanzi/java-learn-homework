package com.example.learn1.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class Student {
    private Integer id;

    private String name;

    private Integer score;

    private Integer age;

    private Integer gender;
}
