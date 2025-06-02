package com.EduVerse.controller.impl;

import com.EduVerse.DTO.*;
import com.EduVerse.controller.UserController;
import com.EduVerse.model.User;
import com.EduVerse.service.Facade.UserFacade;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deneme")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserFacade userFacade;

    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @PostMapping("/login")
    @Override
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto response = userFacade.login(loginRequestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list/{id}")
    @Override
    public User getUserById(@PathVariable(name = "id") int id) {
        return userFacade.getUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/signup")
    @Override
    public ResponseEntity<SigninResponseDto> signin(@RequestBody SigninDto signinDto) {
        SigninResponseDto response = userFacade.signin(signinDto);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @PutMapping("/update")
    @Override
    public ResponseEntity<SigninResponseDto> updateUser(@RequestBody UpdateUserDto updateUserDto) {
        SigninResponseDto response = userFacade.updateUser(updateUserDto);
        return ResponseEntity.ok(response);
    }



    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @PostMapping("/logout")
    @Override
    public ResponseEntity<SigninResponseDto> logout(HttpServletRequest request) {
        SigninResponseDto response = userFacade.logout(request);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @GetMapping("/current-user-id")
    @Override
    public ResponseEntity<Integer> getLoggedInUserId() {
        Integer userId = userFacade.getLoggedInUserId();
        if (userId != null) {
            return ResponseEntity.ok(userId);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
