package com.EduVerse.service;

import com.EduVerse.DTO.*;
import com.EduVerse.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface UserService {
    public LoginResponseDto login(LoginRequestDto loginRequestDto);
    public User getUserById(int id);
    public SigninResponseDto signin(SigninDto signinDto);
    public SigninResponseDto updateUser(UpdateUserDto updateUserDto);
    public SigninResponseDto logout(HttpServletRequest request);
    public Integer getLoggedInUserId();
}
