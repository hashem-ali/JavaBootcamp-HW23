package com.example.spring_week5_day1_exc.controller;

import com.example.spring_week5_day1_exc.model.Student;
import com.example.spring_week5_day1_exc.model.Teacher;
import com.example.spring_week5_day1_exc.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent()
    {
        List<Student> studentList = studentService.getTeacher();
        return ResponseEntity.status(200).body(studentList);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Student student)
    {
        studentService.addTeacher(student);
        return ResponseEntity.status(200).body("Student added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Student student)
    {
        studentService.updateTeacher(id, student);
        return ResponseEntity.status(200).body("Student updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id)
    {
        studentService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Student delete!");
    }
    @PutMapping ("/changeMajor/{id}/major/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id, String major)
    {
        studentService.changeMajor(id, major);
        return ResponseEntity.status(200).body("Student major changed!");
    }

    @PutMapping("/allstudents/{id}")
    public ResponseEntity getAllByClass(@PathVariable Integer id)
    {
        return ResponseEntity.status(200).body(studentService.allStudentsByClass(id));
    }

    @PutMapping("/student/{student_id}/course/{course_id}")
    public ResponseEntity AssignStudentToCourse(@PathVariable Integer student_id, @PathVariable Integer course_id)
    {
        studentService.assignCourseToStudent(student_id, course_id);
        return ResponseEntity.status(200).body("Added");
    }
}
