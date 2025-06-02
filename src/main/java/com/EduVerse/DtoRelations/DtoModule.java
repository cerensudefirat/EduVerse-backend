package com.EduVerse.DtoRelations;


public class DtoModule {
    private Integer moduleId;
    private String moduleTitle;
    private String moduleTime;

    public DtoModule(Integer moduleId, String moduleTitle, String moduleTime) {
        this.moduleId = moduleId;
        this.moduleTitle = moduleTitle;
        this.moduleTime = moduleTime;
    }

    public DtoModule() {
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public String getModuleTime() {
        return moduleTime;
    }

    public void setModuleTime(String moduleTime) {
        this.moduleTime = moduleTime;
    }
}