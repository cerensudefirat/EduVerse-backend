package com.EduVerse.controller.impl;

import com.EduVerse.DtoRelations.*;
import com.EduVerse.controller.RelationsController;
import com.EduVerse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/relations")
public class RelationsControllerImpl implements RelationsController {

    @Autowired
    private RelationsFacade relationsFacade;  // Facade sınıfını enjekte ediyoruz

    @Autowired
    private UserService userService;

    @Autowired
    private FactoryService factoryService;

    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @PostMapping("/getInstructor/{id}")
    @Override
    public ResponseEntity<DtoInstructor> findInstructor(@PathVariable(name = "id") Integer id, @RequestBody DtoInstructor profession) {
        DtoInstructor response = relationsFacade.findInstructor(id, profession);  // Facade üzerinden işlem yapılır
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @PostMapping("/getCourse")
    @Override
    public ResponseEntity<DtoCourse> findCourse(@RequestBody DtoCourse dtoCourse) {
        DtoCourse response = relationsFacade.findCourse(dtoCourse);  // Facade üzerinden işlem yapılır
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getCertifica")
    @Override
    public ResponseEntity<DtoCUser> findCertifica() {
        DtoCUser response = relationsFacade.findCertifica(userService.getLoggedInUserId());  // Facade üzerinden işlem yapılır
        return ResponseEntity.ok(response);
    }

    @PostMapping("/getPayment/{id}")
    @Override
    public ResponseEntity<DtoPayment> findPayment(@PathVariable(name = "id") Integer id, @RequestBody DtoPayment dtoPayment) {
        DtoPayment response = relationsFacade.processPayment(userId, id, dtoPayment);  // Facade üzerinden işlem yapılır
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getUser")
    @Override
    public List<Course> getCourses() {
        return relationsFacade.getCourse(userService.getLoggedInUserId());  // Facade üzerinden işlem yapılır
    }

    @PostMapping("/view")
    @Override
    public ResponseEntity<List<Course>> viewCourse(@RequestBody Course course) {
        List<Course> response = factoryService.viewCourse(course);  // Factory servisinden direkt çağrı yapılır
        return ResponseEntity.ok(response);
    }
}
