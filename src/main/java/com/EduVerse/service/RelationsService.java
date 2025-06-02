package com.EduVerse.service;

import com.EduVerse.DtoRelations.*;
import com.EduVerse.model.Course;

import java.util.List;

public interface RelationsService {
    public DtoInstructor findInstructor(Integer id,DtoInstructor profession);
    public DtoCourse findCourse(DtoCourse dtoCourse);
    public DtoCUser findCertifica(Integer id);
    public DtoPayment processPayment(Integer id,Integer courseId, DtoPayment dtoPayment);
    public List<Course> getCourse(Integer id);
}