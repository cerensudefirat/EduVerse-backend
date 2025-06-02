package com.EduVerse.controller;

import com.EduVerse.DtoRelations.*;
import com.EduVerse.model.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RelationsController {
    public ResponseEntity<DtoInstructor> findInstructor(Integer id,DtoInstructor profession);
    public ResponseEntity<DtoCourse> findCourse(DtoCourse dtoCourse);
    public ResponseEntity<DtoCUser> findCertifica();
    public ResponseEntity<DtoPayment> findPayment(Integer courseId,DtoPayment dtoPayment);
    public List<Course> getCourses();
    public ResponseEntity<List<Course>> viewCourse(Course course);
}
