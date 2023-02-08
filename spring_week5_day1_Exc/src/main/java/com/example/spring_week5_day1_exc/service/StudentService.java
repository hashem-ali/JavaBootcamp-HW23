package com.example.spring_week5_day1_exc.service;

import com.example.spring_week5_day1_exc.apiException.ApiException;
import com.example.spring_week5_day1_exc.model.Course;
import com.example.spring_week5_day1_exc.model.Student;
import com.example.spring_week5_day1_exc.model.Teacher;
import com.example.spring_week5_day1_exc.repository.CourseRepositry;
import com.example.spring_week5_day1_exc.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final CourseRepositry courseRepositry;

    public List<Student> getTeacher()
    {
        return studentRepo.findAll();
    }
    public void addTeacher(Student student)
    {
        studentRepo.save(student);
    }
    public boolean updateTeacher(Integer id, Student student)
    {
        Student student1 = studentRepo.getById(id);
        if(student1 == null)
            return false;
        student.setId(id);
        studentRepo.save(student);
        return true;
    }
    public boolean deleteTeacher(Integer id)
    {
        Student student = studentRepo.getById(id);
        if(student == null)
            return false;
        studentRepo.delete(student);
        return true;
    }

    public void changeMajor(Integer id, String major){
        Student s = studentRepo.getById(id);
        if(s == null){
            throw new ApiException("Not Found");
        }
//    Set<Course> course = s.getCourses();
        s.setMajor(major);
    }

    public Set<Student> allStudentsByClass(Integer class_id){
        Course course = courseRepositry.getById(class_id);
        if(course == null ){
            throw new ApiException("Not Found");
        }
        return course.getStudents();

    }
}
