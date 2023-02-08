package com.example.spring_week5_day1_exc.repository;

import com.example.spring_week5_day1_exc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
