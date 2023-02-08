package com.example.spring_week5_day1_exc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should be not empty!")
    @Size(min = 3,message = "Name most be more than 1 character!")
    private String name;
    @NotEmpty(message = "age should be not empty!")
    private int age;
    @NotEmpty(message = "major should be not empty!")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
