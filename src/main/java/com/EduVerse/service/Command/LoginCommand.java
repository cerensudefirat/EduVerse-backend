package com.EduVerse.service.Command;

import com.EduVerse.DTO.LoginRequestDto;
import com.EduVerse.DTO.LoginResponseDto;
import com.EduVerse.service.UserService;

public class LoginCommand implements Command<LoginResponseDto> {
    private LoginRequestDto loginRequestDto;
    private UserService userService;

    public LoginCommand(LoginRequestDto loginRequestDto, UserService userService) {
        this.loginRequestDto = loginRequestDto;
        this.userService = userService;
    }

    @Override
    public LoginResponseDto execute() {
        return userService.login(loginRequestDto);
    }
}
