package com.example.spring_week5_day1_exc.controller;

import com.example.spring_week5_day1_exc.model.Address;
import com.example.spring_week5_day1_exc.model.Course;
import com.example.spring_week5_day1_exc.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAddress()
    {
        List<Course> addressList = courseService.getTeacher();
        return ResponseEntity.status(200).body(addressList);
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody Course course)
    {
        courseService.addTeacher(course);
        return ResponseEntity.status(200).body("Address added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id, @Valid @RequestBody Course course)
    {
        courseService.updateTeacher(id, course);
        return ResponseEntity.status(200).body("Address updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id)
    {
        courseService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Address deleted!");
    }

}
