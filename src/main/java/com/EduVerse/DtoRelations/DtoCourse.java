package com.EduVerse.DtoRelations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DtoCourse {
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private List<DtoModule> dtoModule;

    private DtoCourse(Builder builder) {
        this.courseId = builder.courseId;
        this.courseName = builder.courseName;
        this.courseDescription = builder.courseDescription;
        this.dtoModule = builder.dtoModule;
    }

    @JsonCreator
    public static DtoCourse create(
            @JsonProperty("courseId") Integer courseId,
            @JsonProperty("courseName") String courseName,
            @JsonProperty("courseDescription") String courseDescription,
            @JsonProperty("dtoModule") List<DtoModule> dtoModule) {
        return new Builder()
                .setCourseId(courseId)
                .setCourseName(courseName)
                .setCourseDescription(courseDescription)
                .setDtoModule(dtoModule)
                .build();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public List<DtoModule> getDtoModule() {
        return dtoModule;
    }

    public static class Builder {
        private Integer courseId;
        private String courseName;
        private String courseDescription;
        private List<DtoModule> dtoModule;

        public Builder setCourseId(Integer courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder setCourseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }

        public Builder setDtoModule(List<DtoModule> dtoModule) {
            this.dtoModule = dtoModule;
            return this;
        }

        public DtoCourse build() {
            return new DtoCourse(this);
        }
    }
}