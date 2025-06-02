package com.EduVerse.service.Command;

import com.EduVerse.DTO.SigninDto;
import com.EduVerse.DTO.SigninResponseDto;
import com.EduVerse.service.UserService;

public class SigninCommand implements Command <SigninResponseDto>{
    private SigninDto signinDto;
    private UserService userService;
    public SigninCommand(SigninDto signinDto, UserService userService) {
        this.signinDto = signinDto;
        this.userService = userService;
    }

    @Override
    public SigninResponseDto execute() {
        return userService.signin(signinDto);
    }
}
