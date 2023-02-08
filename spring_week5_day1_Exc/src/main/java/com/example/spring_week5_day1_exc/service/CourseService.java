package com.example.spring_week5_day1_exc.service;

import com.example.spring_week5_day1_exc.model.Course;
import com.example.spring_week5_day1_exc.model.Teacher;
import com.example.spring_week5_day1_exc.repository.CourseRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepositry courseRepositry;
    public List<Course> getTeacher()
    {
        return courseRepositry.findAll();
    }
    public void addTeacher(Course course)
    {
        courseRepositry.save(course);
    }
    public boolean updateTeacher(Integer id, Course course)
    {
        Course course2 = courseRepositry.getById(id);
        if(course2 == null)
            return false;
        course2.setId(id);
        courseRepositry.save(course);
        return true;
    }
    public boolean deleteTeacher(Integer id)
    {
        Course course = courseRepositry.getById(id);
        if(course == null)
            return false;
        courseRepositry.delete(course);
        return true;
    }
}
