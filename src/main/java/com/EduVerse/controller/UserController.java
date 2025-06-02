package com.EduVerse.controller;

import com.EduVerse.DTO.*;
import com.EduVerse.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto);
    public User getUserById(int id);
    public ResponseEntity<SigninResponseDto> signin (SigninDto signinDto);
    public ResponseEntity<SigninResponseDto> updateUser(UpdateUserDto updateUserDto);
    public ResponseEntity<SigninResponseDto> logout(HttpServletRequest request);
    public ResponseEntity<Integer> getLoggedInUserId();
}
