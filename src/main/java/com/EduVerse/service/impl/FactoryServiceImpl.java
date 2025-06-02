package com.EduVerse.service.impl;

import com.EduVerse.model.Course;
import com.EduVerse.service.FactoryService;
import com.EduVerse.service.factory.ViewCoursesFactory;
import com.EduVerse.service.factory.ViewMethod;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {

    private final ViewCoursesFactory viewCoursesFactory;

    public FactoryServiceImpl(ViewCoursesFactory viewCoursesFactory) {
        this.viewCoursesFactory = viewCoursesFactory;
    }

    @Transactional
    @Override
    public List<Course> viewCourse(Course course) {
        ViewMethod viewMethod = viewCoursesFactory.createViewMethod(course.getCourseName());
        List<Course> coursesResult = new ArrayList<>();
        if (viewMethod != null) {
            coursesResult = viewMethod.viewMethod(course);
        } else {
            System.out.println("No courses found for the specified type.");
        }
        return coursesResult;
    }
}
