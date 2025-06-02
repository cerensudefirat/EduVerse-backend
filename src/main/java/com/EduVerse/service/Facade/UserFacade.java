package com.EduVerse.service.Facade;

import com.EduVerse.DTO.*;
import com.EduVerse.model.User;
import com.EduVerse.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserFacade {
    @Autowired
    private UserService userService;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return userService.login(loginRequestDto);
    }

    public SigninResponseDto signin(SigninDto signinDto) {
        return userService.signin(signinDto);
    }

    public SigninResponseDto updateUser(UpdateUserDto updateUserDto) {
        return userService.updateUser(updateUserDto);
    }

    public SigninResponseDto logout(HttpServletRequest request) {
        return userService.logout(request);
    }

    public User getUserById(int id) {
        return userService.getUserById(id);
    }

    public Integer getLoggedInUserId() {
        return userService.getLoggedInUserId();
    }
}
