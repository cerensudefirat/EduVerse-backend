package com.EduVerse.service.factory;


import com.EduVerse.model.Course;
import com.EduVerse.repository.CourseRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class JavaCourse implements ViewMethod {

    @Autowired
    private CourseRepository courseRepository;

    private static List<Course> courses;

    @PostConstruct
    public void init() {
        if (courseRepository == null) {
            System.out.println("CourseRepository is NULL");
        } else {
            courses = courseRepository.findAll();
            System.out.println("CourseRepository is successfully injected");
        }
    }

    @Override
    public List<Course> viewMethod(Course course) {
        List<Course> getCourse = new ArrayList<>();
        for(Course c : courses) {
            if(c.getCourseName().equals(course.getCourseName())) {
                getCourse.add(c);
            }
        }
        return  getCourse;
    }
}