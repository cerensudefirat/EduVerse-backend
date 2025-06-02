package com.EduVerse.service.impl;

import com.EduVerse.DtoRelations.*;
import com.EduVerse.model.*;
import com.EduVerse.repository.*;
import com.EduVerse.service.RelationsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class RelationsServiceImpl implements RelationsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public DtoInstructor findInstructor(Integer id, DtoInstructor profession) {
        DtoInstructor dtoInstructor = null;

        for (User user : userRepository.findAll()) {
            if (user.getId().equals(id)) {
                Instructor instructor = new Instructor();
                instructor.setProfession(profession.getProfession());


                Instructor savedInstructor = instructorRepository.save(instructor);

                user.setInstructor(savedInstructor);
                userRepository.save(user);

                dtoInstructor = new DtoInstructor.Builder()
                        .setId(user.getId())
                        .setFirstName(user.getFirstName())
                        .setLastName(user.getLastName())
                        .setProfession(profession.getProfession())
                        .build();
            }
        }
        return dtoInstructor;
    }

    @Override
    public DtoCourse findCourse(DtoCourse dtoCourse) {
        List<Modules> savedModules = new ArrayList<>();
        for (DtoModule dtoModule : dtoCourse.getDtoModule()) {
            Modules module = new Modules();
            module.setModuleTitle(dtoModule.getModuleTitle());
            module.setModuleTime(dtoModule.getModuleTime());
            savedModules.add(moduleRepository.save(module));
        }

        Course course = new Course();
        course.setCourseName(dtoCourse.getCourseName());
        course.setCourseDescription(dtoCourse.getCourseDescription());
        course.setModule(savedModules);
        courseRepository.save(course);

        return new DtoCourse.Builder()
                .setCourseId(course.getCourseId())
                .setCourseName(course.getCourseName())
                .setCourseDescription(course.getCourseDescription())
                .setDtoModule(dtoCourse.getDtoModule())
                .build();
    }


    @Override
    public DtoCUser findCertifica(Integer id) {
        DtoCUser dtoCUser = null;

        for (User user : userRepository.findAll()) {
            if (user.getId().equals(id)) {
                List<Course> courses = user.getCourses();

                dtoCUser = new DtoCUser.Builder()
                        .setFirstName(user.getFirstName())
                        .setLastName(user.getLastName())
                        .setCourse(courses)
                        .build();
            }
        }
        return dtoCUser;
    }


    @Transactional
    @Override
    public DtoPayment processPayment(Integer id, Integer courseId, DtoPayment dtoPayment) {
        User user = userRepository.findById(id).get();
        Payment payment = new Payment();
        payment.setPaymentAmount(dtoPayment.getPaymentAmount());
        payment.setPaymentNo(dtoPayment.getPaymentNo());

        List<Payment> currentPayments = user.getPayment();
        if (currentPayments == null) {
            currentPayments = new ArrayList<>();
        }
        currentPayments.add(payment);
        paymentRepository.save(payment);
        user.setPayment(currentPayments);

        List<Course> savedCourses = user.getCourses();
        if (savedCourses == null) {
            savedCourses = new ArrayList<>();
        }
        savedCourses.add(courseRepository.findById(courseId).get());
        user.setCourses(savedCourses);

        userRepository.save(user);
        return dtoPayment;
    }

    @Override
    public List<Course> getCourse(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        List<Course> savedCourses = user.getCourses();
        if (savedCourses == null) {
            savedCourses = new ArrayList<>();
        }
        return savedCourses;
    }


}