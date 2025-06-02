package com.EduVerse.model;

import jakarta.persistence.*;

import java.util.List;

    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "firs_name")
        private String firstName;

        @Column(name="last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @ManyToMany
        @JoinTable(name = "user_course",joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
        private List<Course> courses;

        @ManyToOne
        private Certifica certifica;

        @OneToOne
        private Instructor instructor;

        @ManyToMany
        @JoinTable(name = "user_payment",joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "payment_id") )
        private List<Payment> payment;

    public User(Integer id, String firstName, String lastName, List<Payment> payment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.payment = payment;
    }

    public User(Integer id, String firstName, String lastName, String email, String password, Instructor instructor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.instructor = instructor;
    }

    public User(Integer id, String firstName, String lastName, String email, String password, List<Course> courses, Certifica certifica) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.courses = courses;
        this.certifica = certifica;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Certifica getCertifica() {
        return certifica;
    }

    public void setCertifica(Certifica certifica) {
        this.certifica = certifica;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){
    }
}
