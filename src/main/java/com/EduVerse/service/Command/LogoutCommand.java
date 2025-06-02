package com.EduVerse.service.Command;

import com.EduVerse.DTO.SigninResponseDto;
import com.EduVerse.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command<SigninResponseDto> {
    private HttpServletRequest request;
    private UserService userService;

    public LogoutCommand(HttpServletRequest request, UserService userService) {
        this.request = request;
        this.userService = userService;
    }

    @Override
    public SigninResponseDto execute() {
        return userService.logout(request);
    }
}