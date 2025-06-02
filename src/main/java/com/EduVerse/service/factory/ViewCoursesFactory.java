package com.EduVerse.service.factory;

import org.springframework.stereotype.Component;

@Component
public class ViewCoursesFactory {
    public ViewMethod createViewMethod(String course) {
        if(course == null || course.isEmpty()){
            return null;
        }
        if(course.equals("Java")){
            return new JavaCourse();
        }
        else if(course.equals("Python")){
            return new PythonCourse();
        }
        else if(course.equals("Sql")){
            return new SqlCourse();
        }
        return null;
    }
}
