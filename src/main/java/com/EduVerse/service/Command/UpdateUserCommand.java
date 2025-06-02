package com.EduVerse.service.Command;

import com.EduVerse.DTO.SigninResponseDto;
import com.EduVerse.DTO.UpdateUserDto;
import com.EduVerse.service.UserService;

public class UpdateUserCommand implements Command <SigninResponseDto>{
    private UpdateUserDto updateUserDto;
    private UserService userService;
    public UpdateUserCommand(UpdateUserDto updateUserDto, UserService userService) {
        this.updateUserDto = updateUserDto;
        this.userService = userService;
    }

    @Override
    public SigninResponseDto execute() {
        return userService.updateUser(updateUserDto);
    }
}