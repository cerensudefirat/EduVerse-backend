package com.EduVerse.service.Facade;

import com.EduVerse.DtoRelations.DtoCUser;
import com.EduVerse.DtoRelations.DtoCourse;
import com.EduVerse.DtoRelations.DtoInstructor;
import com.EduVerse.DtoRelations.DtoPayment;
import com.EduVerse.model.Course;
import com.EduVerse.service.RelationsService;
import com.EduVerse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationsFacade {

    @Autowired
    private RelationsService relationsService;

    @Autowired
    private UserService userService;

    public DtoInstructor findInstructor(Integer id, DtoInstructor profession) {
        return relationsService.findInstructor(id, profession);
    }

    public DtoCourse findCourse(DtoCourse dtoCourse) {
        return relationsService.findCourse(dtoCourse);
    }

    public DtoCUser findCertifica(Integer userId) {
        return relationsService.findCertifica(userId);
    }

    public DtoPayment processPayment(Integer userId, Integer paymentId, DtoPayment dtoPayment) {
        return relationsService.processPayment(userId, paymentId, dtoPayment);
    }

    public List<Course> getCourse(Integer userId) {
        return relationsService.getCourse(userId);
    }
}
