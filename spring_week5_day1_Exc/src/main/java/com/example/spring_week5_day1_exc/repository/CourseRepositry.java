package com.example.spring_week5_day1_exc.repository;

import com.example.spring_week5_day1_exc.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositry extends JpaRepository<Course, Integer> {
}
