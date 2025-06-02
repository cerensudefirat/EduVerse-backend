package com.EduVerse.DTO;

public class LoginResponseDto {
    private String message;
    private boolean success;

    public LoginResponseDto(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public LoginResponseDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
