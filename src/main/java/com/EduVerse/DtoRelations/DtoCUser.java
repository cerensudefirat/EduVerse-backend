package com.EduVerse.DtoRelations;
import com.EduVerse.model.Course;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DtoCUser {

    private String firstName;
    private String lastName;
    private List<Course> course;


    public DtoCUser() {
    }


    @JsonCreator
    public DtoCUser(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("course") List<Course> course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }


    private DtoCUser(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.course = builder.course;
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

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private List<Course> course;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setCourse(List<Course> course) {
            this.course = course;
            return this;
        }

        public DtoCUser build() {
            return new DtoCUser(this);
        }
    }
}
