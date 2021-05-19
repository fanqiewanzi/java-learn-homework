package com.learn.demo.POJO;

import lombok.*;

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
