package com.EduVerse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_description")
    private String courseDescription;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_modul", joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "module_id"))
    private List<Modules> module;

    @ManyToOne(fetch = FetchType.EAGER)
    private Certifica certifica;

    private String imageFileName;
    @JsonIgnore
    private transient  Object hipernateteLazyInitializer;


    public Course(String courseName, Integer courseId, String courseDescription) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseDescription = courseDescription;
    }

    public Course(String courseName, String courseDescription, Integer courseId, List<Modules> module) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseId = courseId;
        this.module = module;
    }

    public Course(Integer courseId, String courseName, String courseDescription, Certifica certifica) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.certifica = certifica;
    }

    public Course(Integer courseId, String courseName, String courseDescription, List<Modules> module, Certifica certifica) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.module = module;
        this.certifica = certifica;
    }

    public Course() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Modules> getModule() {
        return module;
    }

    public void setModule(List<Modules> module) {
        this.module = module;
    }

    public Certifica getCertifica() {
        return certifica;
    }

    public void setCertifica(Certifica certifica) {
        this.certifica = certifica;
    }

}
