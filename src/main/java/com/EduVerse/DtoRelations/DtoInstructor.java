package com.EduVerse.DtoRelations;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoInstructor {
    private Integer id;
    private String profession;
    private String firstName;
    private String lastName;

    private DtoInstructor(Builder builder) {
        this.id = builder.id;
        this.profession = builder.profession;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }


    @JsonCreator
    public static DtoInstructor create(
            @JsonProperty("id") Integer id,
            @JsonProperty("profession") String profession,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName) {
        return new Builder()
                .setId(id)
                .setProfession(profession)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }


    public Integer getId() {
        return id;
    }

    public String getProfession() {
        return profession;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder {
        private Integer id;
        private String profession;
        private String firstName;
        private String lastName;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setProfession(String profession) {
            this.profession = profession;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DtoInstructor build() {
            return new DtoInstructor(this);
        }
    }
}