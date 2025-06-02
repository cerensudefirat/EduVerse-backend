package com.EduVerse.model;

import jakarta.persistence.*;
@Entity
@Table(name = "module")
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moduleId;

    @Column(name = "module_title")
    private String moduleTitle;

    @Column(name = "module_time")
    private String moduleTime;

    public Modules() {}

    public Modules(int moduleId, String moduleTitle, String moduleTime) {
        this.moduleId = moduleId;
        this.moduleTitle = moduleTitle;
        this.moduleTime = moduleTime;
    }

    public String getModuleTime() {
        return moduleTime;
    }

    public void setModuleTime(String moduleTime) {
        this.moduleTime = moduleTime;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

}
